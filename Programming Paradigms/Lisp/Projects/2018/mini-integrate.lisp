;;; -*- mode: Lisp;  force emacs into Lisp mode -*-


;;; NOTE: MOST OF THESE FUNCTIONS ARE IMCOMPLETE. THEY HAVE ONLY THE CODE
;;;       NEEDED FOR THE FIVE EXAMPLES (BELOW) TO WORK CORRECTLY.
;;;     THERE'S ALMOST NO COMMENTS.


;;; RWW: OCT 16, 2018

;;------------------------------------------------------------------
;;; edit directory
(defun ld ()
  "load and print - useful even with slime"
  (load "/home/wyatt/Classes/CSC345/Lisp/Projects/2016/mini-integrate.lisp" :print t))

(defun indef-integral (F V) 
  (cond ((variable-p F)(make-quotient (make-power F 2) 2))      
        ((sum-p F)(make-sum(indef-integral(sum-operand-1 F) V)
			   (indef-integral(sum-operand-2 F) V)))
	))

;;===================================================================
;; SYMBOLS

(defconstant variable-symbols       '(U V W X Y Z))
(defconstant sum-symbol             '+)
(defconstant quotient-symbol        '/)
(defconstant power-symbol           '**)

;;===================================================================
;; READERS
;;---------------------------------------------
;; OPERATORS
(defun sum-operator      (F)(first F))
(defun product-operator  (F)(first F))
(defun quotient-operator (F)(first F))

;;---------------------------------------------
;; OPERANDS  

(defun sum-operand-1 (F)(second F))
(defun sum-operand-2 (F)(third F))

;;===================================================================
;; INQUISITORS

(defun variable-p (F) 
  (member F variable-symbols))

(defun sum-p (F)
  (equal (sum-operator F) sum-symbol))

;;===================================================================
;; CONSTRUCTORS


(defun make-variable-name (V) V)

(defun make-sum (F G)
  (cond (t (list sum-symbol F G))))

(defun make-product (F G)
  (cond (t (list product-symbol F G))))

(defun make-quotient (F G)
  (cond (t (list quotient-symbol F G))))

(defun make-power (B E)
  (cond (t (list power-symbol B E))))


;;;===================================================================
;;; functions for testing

(defconstant f1 'x)
(defconstant f2 '(+ x x))
(defconstant f3 '(+ (+ x x)(+ x x)))

;;;===================================================================
;;; TESTING ONLY -- does not, perhaps, exactly match what's needed for the project, but serves to 
;;; illustrate how to do testing 

(defun nice-integrate (F V)
  (format t "FUNCTION: ~a~%VARIABLE: ~a~%  RESULT: ~A~%~%" F V (indef-integral F V)))

(defun t1()  (nice-integrate  f1 'x))
(defun t2()  (nice-integrate  f2 'x))
(defun t3()  (nice-integrate  f3 'x))

;;;===================================================================
