;;;===================================================================

(defmacro me (expr)
  "Shorthand version of macroexpand-1"
  `(macroexpand-1 ',expr))



(defmacro dec (n)
  "Destructively decrement a variable - set n to  (1- n) and return it"
  `(setf ,n (1- ,n)))


;;;==============================================================================
;;; A "better" version of FOR-LOOP macro with C++/Java-style updates			

;;; update syntax:

;;; <var1><func1><update>

;;; <var1> := symbol name consisting of one char
;;; <func1> := function name consisting of one char
;;; <update> := <integer> | <symbol>

;;; examples of allowable updates: i+=2
;;;                                i*=123
;;;                                i/=a
;;;                                is=abc  ; note this one, s is a one-symbol function 

;;; a sample function to be used in the updates
(defun s (n a)(* a n n))				

(defvar a 6)

;;;==============================================================================

(defmacro jfor1 ((var1 eq val1)(var2 op val2)(update) &body body)
  "A defective version"
  (declare (ignore eq)(ignore var2))
  `(do ((,var1 ,val1 ,(make-update update)))
       ((not(,op ,var1 ,val2))				
	(return))                     ;; no return value						
     (progn ,@body)))

;;;==============================================================================

(defmacro jfor ((var1 eq val1)(var2 op val2)(update) &body body)
  "A correct version"
  (declare (ignore eq)(ignore var2))
  (let ((endtest (gensym)))
    `(do* ((,var1 ,val1 ,(make-update update))
	   (,endtest ,val2))
	  ((not(,op ,var1 ,endtest))
	   (return))                 ;; no return value						
       (progn ,@body))))				


;;;=============================================================================

(defun make-update (symbol)
  "Construct the update expression: eg, construct the expression (* i 123) from the symbol i*=123"
  (mapcar #'(lambda(x)(if (all-digits x)(parse-integer x)(intern x)))
	  (let* ((sym-as-char-list (coerce (string symbol) 'list))
		 (operator (string(second sym-as-char-list)))
		 (variable (string(first sym-as-char-list)))
		 (expression (coerce (cdddr sym-as-char-list) 'string)))
	    (list operator variable expression))))

(defun all-digits (s)
  "Return whether a string consists only of digits"
  (eval (cons 'and (mapcar #'digit-char-p (coerce s 'list)))))

;;; =========================================================================
;;;; TEST EXAMPLES					
;;;-----------------------------------------------------------------

(jfor (i = 1)(i <= 10)(i+=2) (print i))                             ;----- OK

(setf a 10)
(jfor (i = 1)(i <= (dec a))(i+=2) (print i))                        ;----- OK

(jfor (i = 1)(i <= 10)(i+=2) (print i))                             ;----- OK					
							
(jfor (i = 1)(i <= 5000)(i*=12) (print i))                          ;----- OK	
  
(jfor (i = 1024)(i >= 1)(i/=2) (print i))                           ;----- OK				

(jfor (i = 1)(i <= 1000)(is=2) (print i))                           ;----- OK 

(jfor (i = 1)(i <= 100000000)(is=11) (print i))                     ;----- OK  

;;;===================================================================
