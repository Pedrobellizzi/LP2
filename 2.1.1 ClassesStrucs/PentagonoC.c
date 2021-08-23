
#include <stdio.h>
#include <math.h>


void main (void) {
   Pent p1 = { 1,1, 15,15,15,15,15 };
   print(&p1);
   
   typedef struct {
      int x, y;
      int l1, l2, l3, l4, l5;
      } Pent;

   void print (Pent* r) {
      printf ("Tamanho dos lados do pentagono (%d,%d,%d,%d,%d) / Posicao (%d,%d)\n",
          r->l1,r->l2,r->l3,r->l4,r->l5, r->x,r->y);
   }
   Return 0

}


