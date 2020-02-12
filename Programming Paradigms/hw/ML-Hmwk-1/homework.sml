(* 
James Speers
Nov 11 2018
CSC 345-80
taz/js637496/CSC345/ML-Hmwk-1/homework.sml
*)


(* ----------------------------------------------------------------------------- *)
(* flip alternate elements of a list, if odd # elements keep last at end of list *)
fun flip (x::y::xs) = if length(xs) > 1 then y::x::flip xs     	       
		      else y::x::xs
  | flip (x::nil) = [x] (* case of 1 item in list *)
  | flip nil = nil;

(* ----------------------------------------------------------------------------- *)
(* deletes the ith element of a list. if len of list is < i return the list  *)
fun deleteIthHelper (x::xs, i) = if length(xs) = i then xs
				 else x::deleteIthHelper (xs, i)
  | deleteIthHelper (nil, i) = nil

fun deleteIth (L, i) = if i > (length(L)) then L
		                 else if i <= 0 then L
		       else deleteIthHelper (L, length(L)-i)
			       

(* ----------------------------------------------------------------------------- *)
(* convert a string to piglatin  *)
fun vowelCheck #"a" = true
  | vowelCheck #"e" = true
  | vowelCheck #"i" = true
  | vowelCheck #"o" = true
  | vowelCheck #"u" = true
  | vowelCheck _ = false

fun hasVowel (x::xs) = if vowelCheck x then true
		       else if length xs > 0 then hasVowel xs
		       else false
  | hasVowel nil = false 			 		   

fun piglatinizeVowel L =  L  @ [#"y",#"a",#"y"]

fun piglatinizeNonVowel (x::xs) = if vowelCheck x then [x] @ xs
				  else piglatinizeNonVowel (xs @ [x])
  | piglatinizeNonVowel nil = nil 			      
				      
fun piglatinizeExploded (x::xs) = if not(hasVowel (x::xs)) then implode (x::xs)
                                  else if vowelCheck x then implode (piglatinizeVowel(x::xs))
				  else implode ((piglatinizeNonVowel(x::xs)) @ [#"a",#"y"])
   | piglatinizeExploded nil = ""					    
 
fun piglatinize w = piglatinizeExploded(explode(w))


	





						       


		      
			  
			  
							 
			  
      
			  
			  
			  

		    
