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

A1   dc.b   $34    

    org $0002

B1   dc.b   $24 

    org $0005
    
C1   dc.b   %10101010

; Main Program Follows:
		org	$0800
		
ENTRY:    ldaa A1           ; a<- M[A1]
          suba B1           ; a <- a- M[B1]
          ldab C1           ; b <- M[C1]
          aba               ; a <- a + b
          cmpa %11001101    ; a - 11001101=? Set Flag Z
          beq CONT          ; Branch if Z = 1 (numbers are equal)
          ldaa #0           ; a <- 0
          staa $0003        ; M[0003] <- a (numbers are not equal, store in 0003)
          bra FIN           ; Branch unconditionally to FIN

CONT:     ldaa #1           ; a <- 1
          staa $0003        ; M[0003] <- a (numbers are equal, store in 0003)

	
; Halt execution
FIN:
		swi
		nop

; Physical end of the program:
		end
