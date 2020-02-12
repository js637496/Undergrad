;;;=============================================================================================
;;; Evaluation of an expression multiple times, and variable capture
;;;=============================================================================================

(defmacro me (expr)
  `(pprint (macroexpand-1 ',expr)))

(defmacro dec (n)
  "Destructively decrement a variable"
  `(setf ,n (1- ,n)))

;;;=============================================================================================
;;; First version of a java-style for loop macro
;;; DEFECTS:  capture, mult-eval

(defmacro for1 (var begin end &body body)
  `(do ((,var ,begin (1+ ,var))) 
       ((> ,var ,end))            ;; END is evaluated on each iteration  -- very bad
     ,@body)))


;;;---------------------------------------------
;;; TESTS -- it initially seems that the macro is correct

;; Test 1 -- OK
CL-USER> (for1 i 1 5 (print i))
1 
2 
3 
4 
5 
NIL

;;;---------------------------
;;; Test 2 -- OK

CL-USER> (defun f(n) n)
F
CL-USER> (for1 i 1 (f 5) (print i))
1 
2 
3 
4 
5 
NIL

;;;---------------------------
;;; Test 3 -- NOT OK   ---  should get: 1 2 3 4 5 

CL-USER> (defvar a 6)
6
CL-USER> (for1 j 1 (dec a) (print j))  ;; END TEST in DO evaluated multiple times - should give: 1 2 3 4 5
1
2
3
NIL

;;;==================================================================================================
;;; FIRST FIX - evaluate the END TEST and bind value to a symbol, NEWEND
;;; DEFECT - the new end test, NEWEND, is subject to VARIABLE CAPTURE

(defmacro for2 (var begin end &body body)
     `(do* ((,var ,begin (1+ ,var))
	  (newend ,end))      
	 ((> ,var newend))           ;; END is now evaluated only once but NEWEND is subject to capture
       ,@body))

;;;------------------------------------------------------
;;;TESTS

;;; Test 4 --  OK
 
CL-USER> (for2 i 1 5 (print i))
1 
2 
3 
4 
5 
NIL

;;;---------------------------------
;;; Test 5 -- OK  (on the above example which failed)

CL-USER> (setf a 6)
6
CL-USER> (for2 j 1 (dec a) (print j))     ;; OK -- 1 2 3 4 5
1
2
3 
4 
5 
NIL

;;;---------------------------------
;;; Test 6 --  NOT OK - NEWEND is subject to VARAIBLE CAPTURE

;;; If we use NEWEND as the for loop control variable, it will conflict with the NEWEND symbol 
;;; in the macro.  This is known as CAPTURE.

CL-USER> (for2 NEWEND 1 5 (print NEWEND))
 -- infinite loop -- as can be seen by the macro expansion


CL-USER> (me (for2 newend 1 5 (print newend)))

(LET ((NEWEND 5))
  (DO ((NEWEND 1 (1+ NEWEND))) ((> NEWEND NEWEND)) (PRINT NEWEND)))  ;; The test is the always false (> NEWEND NEWEND)
; No value

;;; We need to be able to generate a new symbol that is quaranteed to be be new.  GENSYM does this.


;;;=========================================================================
;;; CORRECT VERSION - avoids multiple evaluation and capture


(defmacro for (var begin end &body body)
  (let ((newend (gensym)))
    `(do* ((,var ,begin (1+ ,var))
	  (,newend ,end))
	 ((> ,var ,newend))          
       ,@body)))


;;;----------------------------------------------------------
;;;TESTS

;;;---------------------------------
;;; Test 7 -- OK  

CL-USER> (for i 1 5 (print i))

1 
2 
3 
4 
5 
NIL

;;;---------------------------------
;;; Test 8 -- OK  

CL-USER> (setf a 6)
6
CL-USER> (for2 j 1 (dec a) (print j)) 
1 
2 
3 
4 
5 
NIL
;;;---------------------------------
;;; Test 9 -- OK  

CL-USER> (for newend 1 5 (print newend))
1 
2 
3 
4 
5 
NIL

;;; check the expansion of this case
CL-USER> (me (for newend 1 5 (print newend)))

(DO* ((NEWEND 1 (1+ NEWEND))
      (#:G1563 5))
     ((> NEWEND #:G1563))  ;; note the test here
  (PRINT NEWEND))
; No value

;;;---------------------------------

