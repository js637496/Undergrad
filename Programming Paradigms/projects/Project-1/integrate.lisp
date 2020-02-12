;;; James Speers
;;; Oct 25 2018
;;; CSC 345-80
;;; taz/js637496/CSC345/Poject-1/integrate.lisp


;;; BUG REPORT
;;; ----------
;;; Oct 25 2018 - There are no known bugs at this time


(defun integrate (F V &optional (L nil) (U nil))
  "Integreate check if indefinite or definite integration"
  (cond ((variable-p F) (def-integral (indef-integral F V) V L U))
	 ((number-p F) (def-integral (indef-integral F V) V L U))
	 (t (def-integral (indef-integral (ns F) V) V L U)))) 

(defun indef-integral (F V)
  (cond ((variable-p F) (make-quotient (make-power F 2) 2)) ; Variables
	((number-p F) (make-product F V)) ; Numbers
	((negative-p F) (make-negative (integrate (make-negative F) V))) ; Negative
	((sum-p F) (make-sum (integrate (sum-operand-1 F) V) ; Sum
			     (integrate (sum-operand-2 F) V)))
	((difference-p F) (make-difference (integrate (difference-operand-1 F) V) ; Subtraction
					   (integrate (difference-operand-2 F) V)))
	((and (power-p F) (not (equal (power-operand-2 F) -1))) ; Power n is not -1
	 (make-quotient (make-power V (make-sum (power-operand-2 F) 1))
			(make-sum (power-operand-2 F) 1)))
	((and (power-p F) (equal (power-operand-2 F) -1) (make-log (power-operand-1 F)))) ; Power n = -1
	(t (nil))))	

(defun def-integral (F V L U)
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

;;; PREDICATES

(defun variable-p (F)
  "Is a valid varible symbol?"
  (member F variable-symbols))

(defun number-p (F)
  "Is a number?"
  (numberp F))

(defun negative-p (F)
  "Is negative number or a negation expression?"
  (cond ((and (number-p F) (< F 0)) t) ; is a number and less than 0
 	((number-p F) nil) ; is number and >= 0 f
	((variable-p F) nil)
 	((difference-p F) nil) ; if difference expression f
 	((and (equal (negative-operator F) negative-symbol)  ; if not numbers and not difference and first is -, t
	      (not (equal (negative-operand F) negative-symbol))) t)))

(defun difference-p (F)
  "Is this a difference expression"
  (cond ((number-p F) nil) ; F is a number then not difference
	((variable-p F) nil) ; F is variable symbol then not a difference
	((and (equal (difference-operator F) difference-symbol)   ; First symbol is -
	      (not (equal (difference-operand-1 F) difference-symbol))  ; Second symbol is not - (this would be negation)
	      (difference-operand-2 F)) t))) ; There is a 2nd difference operand symbol		   

(defun sum-p (F)
  "Is this to be summed?"
  (equal (sum-operator F) sum-symbol))

(defun product-p (F)
  "Is this to be multiplied?"
  (equal (product-operator F) product-symbol))

(defun power-p (F)
  "Is this a power expression"
  (cond ((variable-p F) nil)
	((number-p F) nil)
	((equal (power-operator F) power-symbol))))

;;; CONSTRUCTORS

(defun make-varible-name (V)
  "Contruct varible name V"
  V)

(defun make-negative (F) 
  "Construct a negation list or evaluate negative"
  (cond ((number-p F) (* -1 F)) ; if F is numeric then return negation
	((negative-p F) (negative-operand F))	; avoid creating infinite negations
	(t (list negative-symbol F))))

(defun make-sum (F G)
  "Construct or evaluate sum expression"
  (cond ((equal 0 F) G) ; 0 + G = G
	((equal 0 G) F) ; F + 0 = F
	((equal F (make-negative G)) 0) ; F + -F = 0
	((equal G (make-negative F)) 0) ; G + -G = 0
	((and (number-p F) (number-p G)) (+ F G)) ; values to be summed are nums, evaluate
	(t (list sum-symbol F G)))) ; return the symbolic representation of the sum

(defun make-difference (F G)
  "Construct or evaluate difference expression"
  (cond ((equal 0 F) (make-negative G)) ; 0 - G = -G
	((equal 0 G) F) ; F - 0 = F
	((equal F G) 0) ; F - F = 0
	((and (number-p F) (number-p G)) (- F G)) ;  values to be subtracted are nums, evaluate
	(t (list difference-symbol F G)))) ; return the symbolic representation of the difference
  

(defun make-product (F G)
  "Construct or evaluate product expression"
  (cond ((equal 0 F) 0) ; 0 * G = 0
	((equal 0 G) 0) ; F * 0 = 0
	((equal 1 F) G) ; 1 * G = G
	((equal 1 G) F) ; F * 1 = F
	((equal -1 F) (make-negative G)) ; -1 * G = -G
	((equal -1 G) (make-negative F)) ; F * -1 = -F
	((and (negative-p F) (negative-p G)) (make-product (make-negative F) (make-negative G)))
	((and (number-p F) (number-p G)) (* F G)) ; values to be summed are numbers then evaluate
	(t (list product-symbol F G)))) ; return the symbolic representation of the product

(defun make-quotient (F G)
  "Construct or evaluate quotient expression"
  (cond ((equal 0 F) 0) ; 0 / G = 0
	((equal 0 G) nil) ; F is anything other than 0, do not allow divison by 0
	((equal 1 G) F) ; F / 1 =  F
	((equal F G) 1) ; F / F = 1
	((equal -1 G) (make-negative F)) ; F / -1 = -F
	((and (number-p F) (number-p G)) (/ F G)) ; if the two values to be divided are numbers then evaluate
	(t (list quotient-symbol F G)))) ; return the symbolic representation of the quotient

(defun make-power (B E)
  "Construct or evaluate power expression"
  (cond ((and (equal 0 E) (equal 0 B)) nil) ; 0^0 will be represented as undefined
	((equal 0 B) 0) ; 0^N for N != 0 is 0
	((equal 0 E) 1) ; N^0 for N != 0 is 1
	; Maybe account for neg exponent trickery here?
	((and (number-p B) (number-p E)) (expt B E))  ; base and exponent are numbers then evaluate
	(t (list power-symbol B E)))) ; return the symbolic representation of the power expression

(defun make-log (B)
  "Construct log list"
  (cond ((number-p B) (log B))
	(t (list log-symbol B))))

(defun ns (F)
  "Account for multiple negations"
  (labels ((ns-aux (F result count)
	     (cond ((and (endp F) (equal (mod count 2) 1)) (first(rest(reverse result))))
		   ((and (endp F) (equal (mod count 2) 0)) (reverse result))
		   ((and
		     (equal (first F) negative-symbol)
		     (equal (first F) (second F)))
		    (ns-aux (rest F) result (+ count 1)))
		   (t (ns-aux (rest F) (cons (first F) result) count)))))
    (ns-aux F nil 0)))




