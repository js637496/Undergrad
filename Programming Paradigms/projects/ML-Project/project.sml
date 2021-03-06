(* 
James Speers
Dec 1 2018
CSC 345-80
taz/js637496/CSC345/ML-Project/project.sml 
*)

(* For the ML project *)
datatype 'a BT = empty | bTree of 'a * 'a BT * 'a BT ;
(* Don't use NIL for the empty tree as we want it for the empty list *) 
(* a new type -- X, to test the polymorhism on *) 
datatype X = A|B|C|D|E|F|G|H;
(*  TEST DATA - BINARY TREES   *)
val t1 =  bTree(1, 
		bTree(2,bTree(3,empty, empty), bTree(4,empty, empty)),
		bTree(5,bTree(6,empty, empty),bTree(7,empty, empty)));
val t2 =  bTree(A, 
		bTree(B,bTree(D,empty, empty), bTree(E,empty, empty)),
		bTree(C,bTree(F,empty, empty),bTree(G,empty, empty)));
val t3 =  bTree(1.22, bTree(2.33,empty, empty), bTree(3.44,empty,empty));
val t4 =  bTree("A", 
		bTree("B",
		      bTree("C",bTree("E",empty,empty), empty), 
		      bTree("D",
			    bTree("F",empty,empty), 
			    bTree("G",bTree("H",empty,empty), empty))),
		bTree("I",
		      bTree("J",empty, bTree("K",
					     bTree("L",empty, empty),
					     bTree("M",empty, empty))),
		      empty));

(* Binary tree order funs *)
fun preOrder empty = []
  | preOrder (bTree(root,left,right)) =
    [root] @ preOrder left @ preOrder right;

fun inOrder empty = []  
  | inOrder (bTree(root,left,right)) =
    inOrder left @ [root] @ inOrder right;

fun postOrder empty = [] 
  | postOrder (bTree(root,left,right)) =
    postOrder left @ postOrder right @ [root];
    
(* Print funs *)
fun printInt n = print(Int.toString n);   (* Int to String *)
fun printReal n = print(Real.toString n); (* Real to String *)
fun printX A = print "A"                  (* X to String *)
  | printX B = print "B"
  | printX C = print "C"
  | printX D = print "D"
  | printX E = print "E"
  | printX F = print "F"
  | printX G = print "G"
  | printX H = print "H";
  
(* DisplayTree Funs *)
fun tab 0 = print "  "
  | tab count  = (print "  "; tab (count-1) );
(* prints root with printfucntion, then newline *)
fun displayNode (root, count, printMode) = (tab(count);
					       printMode(root);
					       print "\n");
fun dash count = (tab(count);
	      print "  -";
	      print "\n");
fun displayTreeIndent (empty,_,_) = ()
    (* root with no children - root *)
  | displayTreeIndent (bTree(root,empty,empty),count,printMode) =
                                                  (displayNode(root,count,printMode))
    (* root only left child - root left node empty right *)
  | displayTreeIndent (bTree(root,left,empty),count,printMode)  =
                                                  (displayNode(root,count,printMode);
                                                  displayTreeIndent(left,(count+1), printMode);
						  dash (count))    
    (* root right child - root empty left right*)
  | displayTreeIndent (bTree(root,empty,right),count,printMode) =
					          (displayNode(root,count,printMode);
					          dash (count);
					          displayTreeIndent(right,(count+1),printMode))
   (* root both children - root left right *)
  | displayTreeIndent (bTree(root,left,right),count,printMode) =
                                                  (displayNode(root,count,printMode);
                                                  displayTreeIndent(left,(count+1),printMode);
                                                  displayTreeIndent(right,(count+1),printMode))
                                                  						      
fun displayTree(tree,printMode) = displayTreeIndent(tree,0,printMode);

(* Control Funs *)
Control.Print.printDepth := 200;
Control.Print.printLength := 200;
Control.polyEqWarn := false;
