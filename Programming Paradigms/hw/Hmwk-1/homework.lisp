(defun sum (n m)
  "Returns sum of n and m using recursion and 1+ 1- functions"
  (cond ((and (integerp n) (integerp m))
	 (labels ((sum-aux (n m)
		    (cond ((= 0 m) n)
			  ((> m 0) (sum-aux (1+ n) (1- m)))
			  ((< m 0) (sum-aux (1- n) (1+ m))))))
	   (sum-aux n m)))
	(nil)))    

(defun my-replace (e1 e2 L)
  "Returns list L with all occerences of element e1 replaced with e2"
  (cond ((null L) nil)
	((equal e1 L) e2)
	((or (and (listp L) (equal (rest L) e1)) (atom L)) L)
	(t (cons (my-replace e1 e2 (first L))
		 (my-replace e1 e2 (rest L))))))

(defun my-replace2 (e1 e2 L)
  "Returns list L with all occerences of element e1 replaced with e2"
  (cond ((equal e1 L) e2)
	((member e1 L :test #'equal) L)
	(t (cons (my-replace e1 e2 (first L))
		 (my-replace e1 e2 (rest L))))))

(defun fibonacci (n)
  "Normal recursive Fibonacci sequence"
  (cond ((= n 0) n)
	((= n 1) n)
	(t (+ (fibonacci (1- n)) (fibonacci (- n 2))))))

(defun fibonacci-TR (n)
  "Tail end recursion Fibonacci sequence"
  (labels ((fibonacci-TR-aux (n a b)
	     (cond ((= n 0) a)
		   (t (fibonacci-TR-aux (1- n) b (+ a b))))))
    (fibonacci-TR-aux n 0 1)))

(defun sigma (n)
  (cond ((eql (- n 1) 0) 1)
	(t (+ n (sigma (- n 1))))))
	  
	
