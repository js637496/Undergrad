;;; Example to illustrate the difference between macro-expansion time and evaluatation time

(defmacro me (expr)
  "Shorthand version of macroexpand-1 -- and no quote needed"
  `(macroexpand-1 ',expr))

;;;---------------------------------------------------------------------------------------------

(defun fibonacci (n)           ;;; naive recursive, exponential, and inefficient version of fibonacci
  (if (or (= n 0) (= n 1)) 1
    (+ (fibonacci (- n 1))(fibonacci (- n 2)))))

(defmacro fastfibonacci(n)                   ;;; macro version
  (let ((fibn (fibonacci n)))
    `(format t "Fibonacci ~a is ~a.~%" ,n ,fibn)))

(defun slowfibonacci(n)                      ;;; function version
  (let ((fibn (fibonacci n)))
    (format t "Fibonacci ~a is ~a.~%" n fibn)))

(defun fast30 ()                             ;;; uses macro:    slow compilation, but fast evaluation
  "Compute and display fibonacci 30 via a macro"
  (fastfibonacci 30))

(defun slow30 ()                             ;;; uses function: fast compilation, but slow evaluation
  "Compute and display fibonacci 30 via a function"
  (slowfibonacci 30))


;; ;;;==============================================================================
;; ;; run summary

;; (time (compile 'slow30))          ;   0.01 seconds -- fast compilation
;; (time (slow30))                   ;   8.4  seconds -- slow evaluation
;; (time (compile 'fast30))          ;   8.47 seconds -- slow compilation
;; (time (fast30))                   ;   0.0  seconds -- fast evaluation

;; ;;;--------------------------
;; ;;; edited  runs

;; CL-USER> (time (compile 'slow30))
;; ;   0.01 seconds
;; SLOW30

;; CL-USER> (time (slow30))
;; ;   8.4 seconds
;; Fibonacci 30 is 1346269.

;; CL-USER> (time (compile 'fast30))
;; ;   8.47 seconds
;; FAST30

;; CL-USER> (time (fast30))
;; ;   0.0 seconds
;; Fibonacci 30 is 1346269.

;; CL-USER> (time (me '(fastfibonacci 30)))
;; ;   8.47 seconds of real time
;; (FORMAT T "Fibonacci ~a is ~a.~%" 30 1346269)
;; T


;; ;;=========================================================
;; ;;; full runs


;; CL-USER> (time (compile 'slow30))
;; ; Compiling LAMBDA NIL: 
;; ; Compiling Top-Level Form: 
;; ; Compiling LAMBDA NIL: 
;; ; Compiling Top-Level Form: 

;; ; Evaluation took:
;; ;   0.01 seconds of real time
;; ;   0.0 seconds of user run time
;; ;   0.0 seconds of system run time
;; ;   2,082,927 CPU cycles
;; ;   0 page faults and
;; ;   65,144 bytes consed.
;; ; 
;; SLOW30
;; NIL
;; NIL
;; ;-------------------------------------

;; CL-USER> (time (compile 'fast30))
;; ; Compiling LAMBDA NIL: 
;; ; Compiling Top-Level Form: 
;; ; Compiling LAMBDA NIL: 
;; ; Compiling Top-Level Form: 

;; ; Evaluation took:
;; ;   8.47 seconds of real time
;; ;   8.09077 seconds of user run time
;; ;   0.324951 seconds of system run time
;; ;   19,706,021,202 CPU cycles
;; ;   [Run times include 0.23 seconds GC run time]
;; ;   0 page faults and
;; ;   354,507,864 bytes consed.
;; ; 
;; FAST30
;; NIL
;; NIL
;; ;-------------------------------------

;; CL-USER> (time (slow30))
;; ; Compiling LAMBDA NIL: 
;; ; Compiling Top-Level Form: 
;; Fibonacci 30 is 1346269.

;; ; Evaluation took:
;; ;   8.4 seconds of real time
;; ;   8.017781 seconds of user run time
;; ;   0.333949 seconds of system run time
;; ;   19,550,231,204 CPU cycles
;; ;   [Run times include 0.21 seconds GC run time]
;; ;   0 page faults and
;; ;   354,409,960 bytes consed.
;; ; 
;; NIL
;; ;-------------------------------------

;; CL-USER> (time (fast30))
;; ; Compiling LAMBDA NIL: 
;; ; Compiling Top-Level Form: 
;; Fibonacci 30 is 1346269.

;; ; Evaluation took:
;; ;   0.0 seconds of real time
;; ;   0.0 seconds of user run time
;; ;   0.0 seconds of system run time
;; ;   45,682 CPU cycles
;; ;   0 page faults and
;; ;   2,264 bytes consed.
;; ; 
;; NIL
;; ;-------------------------------------

;; CL-USER> (time (macroexpand-1 (fastfibonacci 30)))
;; ; Compiling LAMBDA NIL: 
;; ; Compiling Top-Level Form: 

;; ; Evaluation took:
;; ;   8.47 seconds of real time
;; ;   8.080771 seconds of user run time
;; ;   0.33395 seconds of system run time
;; ;   19,701,757,432 CPU cycles
;; ;   [Run times include 0.22 seconds GC run time]
;; ;   0 page faults and
;; ;   354,393,288 bytes consed.
;; ; 
;; (FORMAT T "Fibonacci ~a is ~a.~%" 30 1346269)
;; T
;; ;-------------------------------------
