#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int r,g,b;
} Color;

struct Figure;
typedef void (* Figure_Print) (struct Figure*);

typedef struct Figure {
    int x, y;
    Color fg, bg;
    void (* print) (struct Figure*);
} Figure;

///////////////////////////////////////////////////////////////////////////////

typedef struct {
    Figure super;
    int w, h;
} Rect;

void rect_print (Rect* this) {
    Figure* sup = (Figure*) this;
    printf("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
           this->w, this->h, sup->x, sup->y);
}

Rect* rect_new (int x, int y, int w, int h) {
    Rect*   this  = malloc(sizeof(Rect));
    Figure* sup = (Figure*) this;
    sup->print = (Figure_Print) rect_print;
    sup->x = x;
    sup->y = y;
    this->w = w;
    this->h = h;
}

///////////////////////////////////////////////////////////////////////////////

typedef struct {
    Figure super;
    int w, h;
} Triangle;

void Triangle_print (Triangle* this) {
    Figure* sup = (Figure*) this;
    printf("Triangulo de largura (%d) e altura (%d) na posicao (%d,%d).\n",
           this->w, this->h, sup->x, sup->y);
}

Triangle* triangle_new (int x, int y, int w, int h) {
    Triangle* this = malloc(sizeof(Triangle));
    Figure* sup = (Figure*) this;
    sup->print = (Figure_Print) Triangle_print;
    sup->x = x;
    sup->y = y;
    this->w = w;
    this->h = h;
}

/////////////////////////////////////////////////////////////////////////////

typedef struct {
    Figure super;
    int x2, y2;
} Line;

void Line_print (Line* this) {
    Figure* sup = (Figure*) this;
    printf("Linha reta que se inicia na posicao (%d,%d) e termina na posicao (%d,%d).\n",
           sup->x, sup->y, this->x2, this->y2);
}

Line* line_new (int x, int y, int x2, int y2) {
    Line* this = malloc(sizeof(Line));
    Figure* sup = (Figure*) this;
    sup->print = (Figure_Print) Line_print;
    sup->x = x;
    sup->y = y;
    this->x2 = x2;
    this->y2 = y2;
}


///////////////////////////////////////////////////////////////////////////////

void main (void) {
    Figure* figs[6] = {
        (Figure*) rect_new(30,20,50,50),
        (Figure*) triangle_new(150,70, 60,40),
        (Figure*) line_new(250,20, 280,100),
        (Figure*) rect_new(30,50,150,50),
        (Figure*) triangle_new(150,200, 80,30),
        (Figure*) line_new(250,130, 290,200),
    };

    ///
    int i;
    for (i=0; i<6; i++) {
        figs[i]->print(figs[i]);
    }

    ///
    
    for (i=0; i<6; i++) {
        free(figs[i]);
    }
}
