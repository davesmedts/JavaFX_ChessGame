+ Namen van packages zijn volgens conventie steeds lowercase, dus exceptions, model, chesspieces zou juister zijn.
+ Piece lijkt me een abstracte klasse te moeten zijn of een interface.  Waarom heb je niet gewoon validMoves()? gedaan en heb je opgesplitst in validMovesPawn() en een gewone validMoves()
  + Volgens mij kan je dit beter aanpakken -> door het huidige bord mee te geven.  Volgens mij heb je dan genoeg informatie om te zien wat een valid move zou zijn.
  + Je weet dat een pawn wit is, dus alleen maar naar boven kan gaan.  Je weet of er stuk voor staat of niet.  Je weet of er een en passant situatie zou kunnen zijn.
  + Je weet of er links en rechts voor een stuk staat.
  + Dan kan je de valid moves teruggeven. Daardoor kan je code wat meer verdelen over je klassen.
  + De code die je geschreven hebt, gaat werken, maar staat volgens mij een beetje op de verkeerde plaats. De Player, de movesvalidator zou je op de stukken zelf kunnen zetten.
+ De klasse player lijkt mij wat te veel verantwoordelijkheid te hebben.
  + Ik zie een method om een piece te selecteren -> lijkt me juist!  Je krijgt een Piece terug.
  + Dan vraag je de validMoves van dat piece (gezien de huidige board situatie, staat uw eigen koning check of niet, wat mag wel en wat niet)  piece.getValidMoves(Board board);
  + Dan kiest hij daar een move van
  + Checked of dit een speciale move is (zie verder)
  + Dan pas je het board aan als gevolg van die move.

je player klasse eenvoudiger maken, gaat leuker zijn als je dat moet integreren met een presenter binnenkort!
Na elke stap kan je dan bijvoorbeeld feedback geven aan de gebruiker.
-> selecteer een stuk!
-> Dit is geen valid move!
-> Bewogen!
-> Promotie -> kies je promotie stuk!
-> Hierbij de nieuwe bordsituatie!


+ De speciale moves daar kan je bijvoorbeeld wel een moves validator voor gebruiken:
  + Daar stop je de rokade in bijvoorbeeld:  Want je gaat moeten bij houden, is de koning bewogen, is de rook bewogen, passeert de koning een aangevallen square enzo.
  + Een promotie

+ Ik merk nog een paar bugjes:
  + De witte pionnen rij is 2
  + De zwarte pionnen rij is 7
  + => en er zijn 8 pionnen
  + In de opening zou ik nooit van B8 naar G7 mogen kunnen bewegen ;-)

De initializePieces heb je nu 2 keer geschreven, voor wit en zwart.
  maar de eigenlijk moet je gewoon de witte pieces hun positie gewoon + 7 doen.
  En bij de pionnen + 5

=> Jullie code lijkt heel volledig, ik zou het gewoon wat beter verdelen en op de juiste plaatsen zetten.
Dus nog wat finetunen en dan gaan we er zijn.
Ik zou dat finetunen wel direct doen, dan gaat de rokade misschien ook wat gemakkelijker te implementeren zijn!

Goed bezig, keep it up!
  
