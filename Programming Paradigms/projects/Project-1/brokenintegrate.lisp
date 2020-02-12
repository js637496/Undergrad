;;; James Speers
;;; Oct 25 2018
;;; CSC 345-80
;;; taz/js637496/CSC345/Poject-1/integrate.lisp


;;; BUG REPORT
;;; ----------
;;; Oct 25 2018 - There are no known bugs at this time


(defun integrate (F V &optional (L nil) (U nil))
  "Integreate check if indefinite or definite integration"
  (def-integral (indef-integral F V) V U L))

(defun indef-integral (F V)
  (cond ((variable-p F) (make-quotient (make-power F 2) 2))                             ; Variables
	((number-p F) (make-product F V))                                               ; Numbers
	((negative-p F) (make-negative (integrate (make-negative F) V)))                ; Negative
	((sum-p F) (make-sum (indef-integral (sum-operand-1 F) V)                       ; Sum
			     (indef-integral (sum-operand-2 F) V)))
;	((difference-p F) (make-difference (integrate (difference-operand-1 F) V)       ; Subtraction
;					   (integrate (difference-operand-2 F) V)))
;	((and (power-p) (not (equal (power-operand-2 F) -1)))
;	 (make-quotient (make-power V (make-sum (power-operand-2) 1))
;			(make-sum (power-operand-1 F) 1)))
;	((and (power-p F) (equal power-operand-2 F) -1) (make-log (power-operand-1 F)))
;						(t (nil))))
	

(defun def-integral (F V U L)
  "Definite integral"
  (cond ((not (and U L)) F)
	(t (eval (make-difference (my-replace V U F) (my-replace V L F))))))

(defun my-replace (e1 e2 L)
  "Returns list L with all occerences of element e1 replaced with e2"
  (cond ((null L) nil)
	((equal e1 L) e2)
	((or (and (listp L) (equal (rest L) e1)) (atom L)) L)
	(t (cons (my-replace e1 e2 (first L))
		 (my-replace e1 e2 (rest L))))))

;;; SYMBOLS

(defconstant variable-symbols '(U V W X Y Z))
(defconstant sum-symbol '+)
(defconstant quotient-symbol '/)
(defconstant power-symbol 'expt)
(defconstant negative-symbol '-) ; would be great if these were not the same symbol
(defconstant difference-symbol '-)
(defconstant product-symbol '*)
(defconstant log-symbol 'log)

;;; SELECTORS -- OPERATORS

(defun negative-operator (F)
  "Get negative-symbol"
  (first F))

(defun sum-operator (F)
  "Get sum-symbol"
  (first F))

(defun quotient-operator (F)
  "Get quotient-symbol"
  (first F))

(defun power-operator (F)
  "Get power-symbol"
  (first F))

(defun difference-operator (F)
  "Get difference-symbol"
  (first F))

(defun product-operator (F)
  "Get product-symbol"
  (first F))

(defun log-operator (F)
  "Get log-symbol"
  (first F))

;;; SELECTORS -- OPERANDS

(defun negative-operand (F)
  "Get element to be negated"
  (second F))

(defun sum-operand-1 (F)
  "Get first element to be summed"
  (second F))
(defun sum-operand-2 (F)
  "Get second element to be summed"
  (third F))

(defun quotient-operand-1 (F)
  "Get first element for division"
  (second F))
(defun quotient-operand-2 (F)
  "Get second element for division"
  (third F))

(defun power-operand-1 (F)
  "Get power's base"
  (second F))
(defun power-operand-2 (F)
  "Get power's exponent"
  (third F))

(defun difference-operand-1 (F)
  "Get first element for subtraction"
  (second F))
(defun difference-operand-2 (F)
  "Get second element for subtraction"
  (third F))

(defun product-operand-1 (F)
  "Get first element for product"
  (second F))
(defun product-operand-2 (F)
  "Get second element for product"
  (third F))

;;;Will log be evaluated?

;;; PREDICATES

(defun variable-p (F)
  "Is a valid varible symbol?"
  (member F variable-symbols))

(defun number-p (F)
  "Is a number?"
  (numberp F))

(defun negative-p (F)
  "Is negative number or a negation expression?"
  (cond ((and (number-p F) (< F 0)) t)       ; is a number and less than 0
 	((number-p F) nil)                   ; is number and >= 0 f
 	((difference-p F) nil)               ; if difference expression f
 	((negative-operator F) t)))          ; if not numbers and not difference and first is -, t

(defun difference-p (F)
  "Is this a difference expression"
  (cond ((number-p F) nil)                                              ; F is a number then not difference
	((variable-p F) nil)                                            ; F is variable symbol then not a difference
	((and (equal (difference-operator F) difference-symbol)         ; First symbol is -
	      (not (equal (difference-operand-1 F) difference-symbol))  ; Second symbol is not - (this would be negation)
	      (difference-operand-2 F)) t)))                            ; There is a 2nd difference operanrd symbol
		   

(defun sum-p (F)
  "Is this to be summed?"
  (equal (sum-operator F) sum-symbol))

(defun product-p (F)
  "Is this to be multiplied?"
  (equal (product-operator F) product-symbol))

(defun power-p (F)
  "Is this a power expression"
  (equal ((power-operator F) power-symbol))




;;; Start with sum, then get others working

;;; CONSTRUCTORS

(defun make-varible-name (V)
  "Contruct varible name V"
  V)

(defun make-negative (F) 
  "Construct a negation list or evaluate negative"
  (cond ((number-p F) (* -1 F))                     ; if F is numeric then return negation
        ; negatiting a negative, avoid creating (- - - - - X) return the negative-operand
	(t (list negative-symbol F))))

(defun make-sum (F G)
  "Construct or evaluate sum expression"
  (cond ((eq 0 F) G)                               ; 0 + G = G
	((eq 0 G) F)                               ; F + 0 = F
	((eq F (make-negative G)) 0)               ; F + -F = 0
	((eq G (make-negative F)) 0)               ; G + -G = 0
	((and (number-p F) (number-p G)) (+ F G))  ; if the two values to be summed are numbers then evaluate
	(t (list sum-symbol F G))))                ; Otherwise return the symbolic representation of the sum

(defun make-difference (F G)
  "Construct or evaluate difference expression"
  (cond ((eq 0 F) (make-negative G))               ; 0 - G = -G
	((eq 0 G) F)                               ; F - 0 = F
	((eq F G) 0)                               ; F - F = 0
	((and (number-p F) (number-p G)) (- F G))  ; if the two values to be subtacted are numbers then evaluate
	(t (list difference-symbol F G))))         ; Otherwise return the symbolic representation of the difference
  

(defun make-product (F G)
  "Construct or evaluate product expression"
  (cond ((eq 0 F) 0)                               ; 0 * G = 0
	((eq 0 G) 0)                               ; F * 0 = 0
	((eq 1 F) G)                               ; 1 * G = G
	((eq 1 G) F)                               ; F * 1 = F
	((eq -1 F) (make-negative G))                ; -1 * G = -G
	((eq -1 G) (make-negative F))                ; F * -1 = -F
	; G and F are both negative result will be eq to -F * -G, could also try -1 * (F * G) route
        ((and (negative-p F) (negative-p G)) (make-product (make-negative F) (make-negative G)))
	((and (number-p F) (number-p G)) (* F G))  ; if the two values to be summed are numbers then evaluate
	(t (list product-symbol F G))))            ; Otherwise return the symbolic representation of the product

(defun make-quotient (F G)
  "Construct or evaluate quotient expression"
  (cond ((eq 0 F) 0)                               ; 0 / G = 0
	((eq 0 G) nil)                             ; F is anything other than 0, do not allow divison by 0
	((eq 1 G) F)                               ; F / 1 =  F
	((eq F G) 1)                               ; F / F = 1
	((eq -1 G) (make-negative F))                ; F / -1 = -F
	((and (number-p F) (number-p G)) (/ F G))  ; if the two values to be divided are numbers then evaluate
	(t (list quotient-symbol F G))))            ; Otherwise return the symbolic representation of the quotient

(defun make-power (B E)
  "Construct or evaluate power expression"
  (cond ((and (eq 0 E) (eq 0 B)) nil)                 ; 0^0 will be represented as undefined
	((eq 0 B) 0)                                  ; 0^N for N != 0 is 0
	((eq 0 E) 1)                                  ; N^0 for N != 0 is 1
	; Maybe account for neg exponent trickery here?
	((and (number-p B) (number-p E)) (expt B E))  ; if the base and exponent are numbers then evaluate
	(t (list power-symbol B E))))                 ; Otherwise return the symbolic representation of the power expression



;;; test functions

(defconstant f1 'x)
(defconstant f2 '(+ x x))
(defconstant f3 '(+ (+ x x)(+ x x)))


;;; testing only
(defun nice-integrate (F V &optional (L nil) (U nil))
  (format t "FUNCTION: ~a~%VARIABLE: ~a~% RESULT: ~A~%~%" F V (integrate F V L U)))

(defun t1() (nice-integrate '1 'x))
(defun t2() (nice-integrate '1 'y 1 4))
(defun t3() (nice-integrate 'z 'z))
(defun t4() (nice-integrate '(+ x 0) 'x))
(defun t5() (nice-integrate '(- x) 'x 1 3))
(defun t6() (nice-integrate '(- - x) 'x 1 4))
(defun t7() (nice-integrate '(- x) 'x))
(defun t8() (nice-integrate '(- - x) 'x))
(defun t9() (nice-integrate '(- - - x) 'x))
(defun t10() (nice-integrate '(+ x (- x)) 'x))
(defun t11() (nice-integrate '(- (+ (- - x) x)) 'x 1 4))
(defun t12() (nice-integrate '(+ (+ x (- - x) (+ x 3)) 2) 'x 2 6))
(defun t13() (nice-integrate '(- x (expt x 3)) 'x))
(defun t14() (nice-integrate '(- x (expt x 3)) 'x 2 5))
(defun t15() (nice-integrate '(+ (+ x (- - - x)) (expt x 3)) 'x))
(defun t16() (nice-integrate '(+ (- x (- x)) (expt x 3)) 'x 2 3))
(defun t17() (nice-integrate '(expt x -1) 'x))
(defun t18() (nice-integrate '(expt x -1) 'x 3 45))
(defun t19() (nice-integrate '(+ (+ x (- 5 x)) (expt x -1)) 'x))
(defun t20() (nice-integrate '(+ (+ x (- 5 x)) (expt x -1)) 'x 5 217))





