;;;  A few simple macros
;;;===================================================================

(defmacro me (expr)
  "Shorthand version of macroexpand-1 -- and no quote needed"
  `(macroexpand-1 ',expr))

;;;-------------------------------------------------------------------

;;; Correct and incorrect use of backquote and commas
(defmacro func(a b)
  `( + ,a ,b ,`(+ ,a ,b)))      ;;; Note double backquotes

; (defmacro func2(a b)          ;;; Incorrect: last two commas not inside a backquote
;   `( + ,a ,b ,(+ ,a ,b)))

;;;-------------------------------------------------------------------

(defmacro myfirst (L)
  "My version of first using a macro"
  `(first ',L))

;;;-------------------------------------------------------------------

(defmacro myand (&body body)
  "My version of and using a macro - and having short-circiut evaluation"
  `(and ,@body))

;;;-------------------------------------------------------------------

(defmacro dec (n)
  "Destructively decrement a variable - set n to  (1- n) and return it"
  `(setf ,n (1- ,n)))

;;;-------------------------------------------------------------------
;;; Do not use a macro when a function will do 

(defmacro everym (func L)
  "Test to see if every member of L satisfies function FUNC -- using a macro"
   (eval `(cons 'and (mapcar ,func ,L))))

;;; function version - simpler and therefore better
(defun everyf (func L)
  "Test to see if every member of L satisfies function FUNC -- using a function"
  (eval (cons 'and (mapcar func L))))

;;;-------------------------------------------------------------------
