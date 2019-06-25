;*****************************************************************
;* CMPT 150 assembly project template (1071)                     *
;* Tony Dixon, School of Computing Science                       *
;* Portions Copyright 2006, School of Engineering Science, SFU   *
;*****************************************************************

; Prepared for Metrowerks Codewarrior v3.

		include preamble.inc	; Do not change this line.

******************************************************************
* Your main program instructions must immediately follow the     *
* label "ENTRY".  This label must not be changed.                *
******************************************************************
	
; Data Declarations Follow:
		org	$0000

A1   dc.b   $36    
B1   dc.w   $22 

; Main Program Follows:
		org	$0800
ENTRY:     

LOOP:
      clra          ; a <- 0
      ldab A1       ; b <- M[A1]
      ldx B1        ; x <- M[B1]
      idiv          ; D/X -> X, Remainder in D
      cpd #0        ; D-0 = ? Set Flag Z
      beq CONT      ; Branch if Z=1 (Remainder=0)
      ldaa $0002    ; a <- M[0002]
      staa $0000    ; M[0000] <- a (Previous divisor into A1) 
      clr $0001     ; M[0001] <- 0
      stab $0002    ; M[0002] <- b (Remainder)
      bra LOOP      ; Branch unconditionally back to LOOP
      
         
CONT:
      exg d,x       ; Exchange registers D <-> X
      stab $0002    ; M[0002] <- Result
	
; Halt execution
		swi
		nop

; Physical end of the program:
		end
