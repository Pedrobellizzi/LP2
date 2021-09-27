#include <stdio.h>
#include <stdlib.h>
#include <math.h>

typedef struct {
    int r,g,b;
} Color;

struct Figure;
typedef void (* Figure_Print) (struct Figure*);
typedef int  (* Figure_Area)  (struct Figure*);
typedef int  (* Figure_Perim) (struct Figure*);

typedef struct {
    void (* print) (struct Figure*);
    int  (* area)  (struct Figure*);
    int  (* perim) (struct Figure*);
} Figure_vtable;

typedef struct Figure {
    int x, y;
    Color fg, bg;
    Figure_vtable* vtable;
} Figure;

///////////////////////////////////////////////////////////////////////////////

typedef struct {
    Figure super;
    int w, h;
} Rect;

void rect_print (Rect* this) {
    Figure* sup = (Figure*) this;
    printf("Retangulo de tamanho (%d,%d) na posicao (%d,%d) com area (%d) e perimetro (%d).\n",
           this->w, this->h, sup->x, sup->y, sup->vtable->area(sup), sup->vtable->perim(sup));
}

int rect_area (Rect* this) {
    Figure* sup = (Figure*) this;
    return this->w * this->h;
}


int rect_perim (Rect* this) {
    Figure* sup = (Figure*) this;
    return ((this->w + this->h) * 2);
}


Figure_vtable rect_vtable = {
    (Figure_Print) rect_print,
    (Figure_Area)  rect_area,
    (Figure_Perim)  rect_perim
};

Rect* rect_new (int x, int y, int w, int h) {
    Rect*   this  = malloc(sizeof(Rect));
    Figure* sup = (Figure*) this;
    sup->vtable = &rect_vtable;
    sup->x = x;
    sup->y = y;
    this->w = w;
    this->h = h;
}

///////////////////////////////////////////////////////////////////////////////

typedef struct {
    Figure super;
    int w, h;
    int x2,x3, y2,y3;
} Triangle;

void triangle_print (Triangle* this) {
    Figure* sup = (Figure*) this;
    printf("Triangulo de largura (%d) e altura (%d) vertice de cima comecando na posicao (%d,%d) com area (%d) e perimetro (%d).\n",
           this->w, this->h, sup->x, sup->y, sup->vtable->area(sup), sup->vtable->perim(sup));
}

int triangle_area (Triangle* this) {
    Figure* sup = (Figure*) this;
    return (this->w * this->h)/2;
}

int triangle_perim (Triangle* this) {
    Figure* sup = (Figure*) this;
    return (sqrt(((this->x2 - sup->x)^2)+((this->y2 - sup->y)^2)) + sqrt(((this->x3 - this->x2)^2)+((this->y3 - this->y2)^2)) + sqrt(((sup->x - this->x3)^2)+((sup->y - this->y3)^2)));
}

Figure_vtable triangle_vtable = {
    (Figure_Print) triangle_print,
    (Figure_Area)  triangle_area,
    (Figure_Perim)  triangle_perim
};

Triangle* triangle_new (int x, int x2, int x3, int y, int y2, int y3) {
    Triangle* this = malloc(sizeof(Triangle));
    Figure* sup = (Figure*) this;
    sup->vtable = &triangle_vtable;
    sup->x = x;
    sup->y = y;
    this->x2 = x+40;
	this->x3 = x-40;
    this->y2 = y+40;
    this->y3 = y+40;
    this->w = this->x2 - this->x3;
	this->h = this->y3 - sup->y;	
}

/////////////////////////////////////////////////////////////////////////////

typedef struct {
    Figure super;
    int x2, y2;
    int w, h;
} Line;

void line_print (Line* this) {
    Figure* sup = (Figure*) this;
    printf("Linha reta que se inicia na posicao (%d,%d) e termina na posicao (%d,%d) correpondente a diagonal de um retangulo com area (%d,%d) de perimetro ou comprimento (%d).\n",
           sup->x, sup->y, this->x2, this->y2, sup->vtable->area(sup), sup->vtable->perim(sup));
}

int line_area (Line* this) {
    Figure* sup = (Figure*) this;
    return this->w * this->h;
}


int line_perim (Line* this) {
    Figure* sup = (Figure*) this;
    return sqrt(((this->x2 - sup->x)^2)+((this->y2 - sup->y)^2)) ;
}

Figure_vtable line_vtable = {
    (Figure_Print) line_print,
    (Figure_Area)  line_area,
    (Figure_Area)  line_perim
};


Line* line_new (int x, int x2, int y, int y2) {
    Line* this = malloc(sizeof(Line));
    Figure* sup = (Figure*) this;
    sup->vtable = &line_vtable;
    sup->x = x;
    sup->y = y;
    this->x2 = x2;
    this->y2 = y2;
    this->w = this->x2 - sup->x;
	this->h = this->y2 - sup->y;
}

///////////////////////////////////////////////////////////////////////////////

void main (void) {
    Figure* figs[6] = {
        (Figure*) rect_new(10,10,100,100),
        (Figure*) triangle_new(100,150,50,50,150,150),
        (Figure*) line_new(250,300,250,350),
        (Figure*) rect_new(30,30,50,70),
        (Figure*) triangle_new(200,360,140,250,320,320),
        (Figure*) line_new(150,100,150,250)
    };

    ///
    
    int i;
    for (i=0; i<6; i++) {
        figs[i]->vtable->print(figs[i]);
    }

    ///

    for (i=0; i<6; i++) {
        free(figs[i]);
    }
}
