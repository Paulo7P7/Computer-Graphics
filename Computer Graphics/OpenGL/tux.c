#include <GL/glut.h>
#include <stdlib.h>


/* Matrix de parametros de bits p/ desenhar o tux em
em Hexadecimal  */
GLubyte tux[] = {
 0x0,  0x0,  0x0,  0x0, 
 0x0,  0x0,  0x0,  0x0, 
 0x0,  0x0,  0x0,  0x0, 
 0x0,  0x0,  0x0,  0x0, 
 0x0,  0x0,  0x0,  0x0, 
 0x0,  0x0,  0x0,  0x0, 
 0x0,  0x7f,  0xfe,  0x0, 
 0x0,  0xc4,  0x23,  0x0, 
 0x1,  0x83,  0x21,  0x80, 
 0x1,  0x7,  0xe0,  0x80, 
 0x1,  0x7,  0xf0,  0x80, 
 0x1,  0x8f,  0xf9,  0x80, 
 0x0,  0xff,  0xff,  0x0, 
 0x0,  0x4f,  0xf1,  0x0, 
 0x0,  0x6f,  0xf1,  0x0, 
 0x0,  0x2f,  0xf3,  0x0, 
 0x0,  0x27,  0xe2,  0x0, 
 0x0,  0x30,  0x66,  0x0, 
 0x0,  0x1b,  0x1c,  0x0, 
 0x0,  0xb,  0x88,  0x0, 
 0x0,  0xb,  0x98,  0x0, 
 0x0,  0x8,  0x18,  0x0, 
 0x0,  0xa,  0x90,  0x0, 
 0x0,  0x8,  0x10,  0x0, 
 0x0,  0xc,  0x30,  0x0, 
 0x0,  0x6,  0x60,  0x0, 
 0x0,  0x3,  0xc0,  0x0, 
 0x0,  0x0,  0x0,  0x0, 
 0x0,  0x0,  0x0,  0x0, 
 0x0,  0x0,  0x0,  0x0, 
 0x0,  0x0,  0x0,  0x0, 
 0x0,  0x0,  0x0,  0x0
};

GLfloat r,g,b;



/* inicializa a janela de rendering
Inicializa e atribui parametros a� view port*/
void init(void);
// imprime na tela
void display(void);
// fun�ao a ser execultada quando capturar o teclado
void keyboard(unsigned char key, int x, int y);
// fun�ao a ser execultada quando capturar o teclado
void mouse(int button, int state, int x, int y);


int main(int argc, char** argv){
  //Inicializa�ao bibliotecas do GLUT
  glutInit(&argc, argv);
  /*Inicializa�ao da janela - Estabelece o tipo de recurso necess�rio 
  para as janelas que ser�o criadas.*/
  glutInitDisplayMode (GLUT_DOUBLE | GLUT_RGB);
  //Estabelece o tamanho da janela a ser criada
  glutInitWindowSize (256, 256); 
  /*Estabelece a posi��o inicial do canto superior esquerdo da 
  janela a ser criada*/
  glutInitWindowPosition (100, 100); 
  //Cria uma janela com o nome especificado
  glutCreateWindow ("Preenchendo regi�es");
  init();
  // Inicializar Callbacks
  glutDisplayFunc(display); 
  //Interagir com o teclado
  glutKeyboardFunc(keyboard);
  //Interagir com o mouse
  glutMouseFunc(mouse);
  //Renderiza a cena e aguarda interações
  glutMainLoop();
  return 0;
}


void init(void){
  glClearColor(1.0, 1.0, 1.0, 1.0);
  glOrtho (0, 256, 0, 256, -1 ,1);
  r=0; g=1; b=0; // Atribui os valores do RGB
} 


void display(void){
  int i;
  glClear(GL_COLOR_BUFFER_BIT);
  // Desabilita a mascara de preenchimento pr�-definida [Tux]
  glDisable(GL_POLYGON_STIPPLE);

  // Imprime na tela um poligono sem preenchimento
  glPolygonMode(GL_BACK, GL_LINE);
    glColor3f(1.0, 0.0, 0.0);
    glBegin(GL_POLYGON);
    glVertex2i(30,226);  glVertex2i(113,226);
    glVertex2i(113,143); glVertex2i(30,143); 
  glEnd();

  // Imprime na tela um poligono prenchido
  glPolygonMode(GL_BACK, GL_FILL);
    glColor3f(r, g, b);
    glBegin(GL_POLYGON);
    glVertex2i(143,226); glVertex2i(226,226);
    glVertex2i(226,143); glVertex2i(143,143); 
  glEnd();

  // Imprime na tela um poligono em degradê
  glBegin(GL_POLYGON);
    glColor3f(1.0, 0.0, 0.0);  glVertex2i(30,113);  
    glColor3f(0.0, 1.0, 0.0);  glVertex2i(113,113);
    glColor3f(0.0, 0.0, 1.0);  glVertex2i(113,30);  
    glColor3f(1.0, 1.0, 0.0);  glVertex2i(30,30); 
  glEnd();

  // Abilita a mascara de preenchimento pr�definida [Tux]
  glEnable(GL_POLYGON_STIPPLE);
  glColor3f(1.0, 0.0, 1.0);
  glPolygonStipple(tux);

  // Imprime na tela um poligono com a m�scara de [Tux]
  glBegin(GL_POLYGON);
    glVertex2i(143,113); glVertex2i(226,113);
    glVertex2i(226,30); glVertex2i(143,30); 
  glEnd();

  glFlush();
  /* � usada no lugar da glFlush porque quando � feita a 
  troca (ou swap) de buffers, � realizada implicitamente uma 
  opera��oo de flush. Esta fun�oo continua fazendo o flush 
  mesmo que o programa esteja sendo executado no modo 
  single-buffer, porem com uma qualidade bastante inferio */
  glutSwapBuffers();

}/

void keyboard(unsigned char key, int x, int y){
  switch (key) {
  case 27: // ASCII da tecla [Esc]
  	exit(0); // Finaliza o progama
  	break;
  }
}

void mouse(int button, int state, int x, int y){
  /*
    - button define o bot�o que foi clicado no mouse
    - state define 
    - x e y s�o coordenada do mouse no momento da 
      intera�ao do */
  switch (button) {
    case GLUT_LEFT_BUTTON:
    	if (state == GLUT_DOWN) {
        // Gera uma nova combinação de RGB randomicamente
    	  r=(GLfloat)rand()/(RAND_MAX+1.0);
    	  g=(GLfloat)rand()/(RAND_MAX+1.0);
    	  b=(GLfloat)rand()/(RAND_MAX+1.0);
    	  /* a fun�ao display � chamada novamente, fazendo 
        com que a janela corrente seja redesenhada */
        glutPostRedisplay(); 
    	}
    	break;
  }
}