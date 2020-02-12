(defun AllBut (N L)
  "Return everything in list expcept the first N members"
  (assert (numberp N) (N)
	  "N must be an integer, instead it is ~S." N)
  (cond ((endp L) nil)
	(t (append (AllBut ((1- N) (rest L)))))))
