;;;==============================================================================
;;; DEFUNC - define a curried function of two arguments


;;;******************************************************************************

(defmacro defunc (funname (v1 v2) funbody)
  (let* ((newvar (gensym))
	 (v2-supplied-p (gensym))
	 (newbody (subst newvar v2 funbody)))
    `(defun ,funname (,v1 &optional (,v2 0 ,v2-supplied-p ))
       (if ,v2-supplied-p
	   ,funbody
	   #'(lambda (,newvar) ,newbody)))))


;;;******************************************************************************
;;; EXAMPLE FUNCTION DEFINITIONS

(defunc add (x y) (+ x y))                            ;; curried version of: add 
(defunc power1 (x y) (expt x y))                      ;; curried version of: power
(defunc power2 (x y) (expt y x))                      ;; curried version of: power
(defunc addmult (a b) (if (= a b) (+ a b) (* a b)))   ;; curried version of: add-or-mult


;;; We can bind a partially instantiated function to a function symbol -- examples

(setf (symbol-function 'add2) (add 2))
(setf (symbol-function (lambda (x)(+ x 2))))



;;;******************************************************************************
;;  To get emacs to treat DEFUNC with the same font as DEFUN, include in your ~/.emacs:

;;     (font-lock-add-keywords 'lisp-mode
;;         '(("defunc" . font-lock-keyword-face)))


;;;******************************************************************************
;;; An example to work from: ADD
;;;
;;;     (defunc add (x y) (+ x y))   
;;;
;;;  We need this to translate into:
;;;
;;;     (defun add (x &optional (y 0 y-supplied-p))
;;;       (if y-supplied-p
;;;           (+ x y)
;;;         #'(lambda (y)(+ x y))))


;;;******************************************************************************
;;;  RUN
;;;
;;;  CL-USER> (add 3 4)
;;;  7

;;;  CL-USER> (funcall (add 3) 4)
;;;  7

;;;  CL-USER> (setf (symbol-function 'add3) (add 3))
;;;  #<Interpreted Function "LAMBDA (X &OPTIONAL (Y 0 G1642))" {5BA02A29}>

;;;  CL-USER> (add3 4)
;;;  7

