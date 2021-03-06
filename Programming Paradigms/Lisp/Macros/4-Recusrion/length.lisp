;;;===================================================================
RECURSION

A recursive macro will fail because when it compiles. It cannot
terminate as it never reaches the termination case of nil.  It cannot
reach it because the values of the successive arguments are not known
until evaluation time.

;;;===================================================================

(defun mylengthf(L)
  "A version of length"
  (cond ((endp L) 0)
	(t (1+ (mylength(rest L))))))

(defmacro mylengthm(L)
  "An attempted macro version of length"
  `(cond ((endp ,L) 0)
	(t (1+ (mylengthm (rest ,L))))))

(defmacro mylengthmm(L)
  "A monitored version of an attempted macro version of length"
  (format t "~a~%"  L) ;; MONITOR THE ARGUMENT VALUE
  `(cond ((endp ,L) 0)
	 (t (1+ (mylengthmm (rest ,L))))))

;;;===================================================================
;;; RUNS 

CL-USER> (mylength '(q w e r t y))
6


CL-USER> (macroexpand-1 (mylengthm '(q w e)))
; Evaluation aborted.


CL-USER> (macroexpand-1 (mylengthmm '(q w e)))

'(Q W E)
'(Q W E)
(REST '(Q W E))
(REST (REST '(Q W E)))
(REST (REST (REST '(Q W E))))
(REST (REST (REST (REST '(Q W E)))))
(REST (REST (REST (REST (REST '(Q W E))))))
(REST (REST (REST (REST (REST (REST '(Q W E)))))))
(REST (REST (REST (REST (REST (REST (REST '(Q W E))))))))
(REST (REST (REST (REST (REST (REST (REST (REST '(Q W E)))))))))
(REST (REST (REST (REST (REST (REST (REST (REST (REST '(Q W E))))))))))
................etc.............

; Evaluation aborted.

