
;;; Construct Haskell-style list comprehensions and use them to do quicksort
;;;===========================================================================


(defmacro me1 (expr)
  `(pprint (macroexpand-1 ',expr)))

;;;===========================================================================
;;; Test lists for quicksort

(defvar xs '(1 3 5 6 8 2 7 9 4))

(defvar ys '(7 45 3 6 9 7 1 2 4 6 8 23 76 4 90 65 1 -4))

;;;----------------------------------------------------------------------------
;;; A version of the Haskell-style comprehnesion

(defmacro comprehension (var from source body)
  (declare (ignore from))   ;; FROM is not used - ignore it to avoid a warning
  (let* ((newvar (gensym))
	 (newbody (subst `(first ,newvar) var body)))
    `(labels ((func (,newvar)
		    (cond ((endp ,newvar) nil)
			  (,newbody (cons (first ,newvar)(func (rest ,newvar))))
			  (t (func (rest ,newvar))))))
       (func ,source))))

;;;===========================================================================
;;; Two other versions of the comprehension - simpler but less instructive

;;; A version using REMOVE-IF-NOT
(defmacro comprehension2 (var from source body)
  (declare (ignore from))
  (let* ((newvar (gensym))
	 (newbody (subst newvar var body)))
    `(remove-if-not #'(lambda(,newvar) ,newbody) ,source)))

;;; A version using MAPCAN
(defmacro comprehension3 (var from source body)
  (declare (ignore from))
  (let* ((newvar (gensym))
	 (newbody (subst newvar var body)))
    `(mapcan #'(lambda(,newvar) (if ,newbody (list ,newvar))) ,source)))

;;;----------------------------------------------------------------------------
;;; Quicksort implemented using comprehensions

(defun quicksort (L)
  (if (endp (rest L)) L
      (append (quicksort (comprehension x <- (rest L) (<= x (first L))))
	      (list (first L)) 
	      (quicksort (comprehension x <- (rest L) (> x (first L)))))))

;;;----------------------------------------------------------------------------
;;; RUNS

;;;  CL-USER> xs
;;;  (1 3 5 6 8 2 7 9 4)
;;;  CL-USER> (quicksort xs)
;;;  (1 2 3 4 5 6 7 8 9)
;;;
;;;  CL-USER> ys
;;;  (7 45 3 6 9 7 1 2 4 6 8 23 76 4 90 65 1 -4)
;;;  CL-USER> (quicksort ys)
;;;  (-4 1 1 2 3 4 4 6 6 7 7 8 9 23 45 65 76 90)
