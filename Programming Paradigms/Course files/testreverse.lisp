(defun deepReverse (L)
  "Deep reverse"
  (cond ((endp L) nil)
	(t (append (deepReverse (rest L))
		   (if (listp (first L)) (list (deepReverse (first L)))
		       (list (first L)))))))
							   
