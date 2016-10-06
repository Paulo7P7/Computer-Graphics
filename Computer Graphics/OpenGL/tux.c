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
Inicializa e atribui parametros a  view port*/
void init(void);
// imprime na tela
void display(void);
// funçao a ser execultada quando capturar o teclado
void keyboard(unsigned char key, int x, int y);
// funçao a ser execultada quando capturar o teclado
void mouse(int button, int state, int x, int y);


int main(int argc, char** argv){
  //Inicializaçao bibliotecas do GLUT
  glutInit(&argc, argv);
  /*Inicializaçao da janela - Estabelece o tipo de recurso necessário 
  para as janelas que serão criadas.*/
  glutInitDisplayMode (GLUT_DOUBLE | GLUT_RGB);
  //Estabelece o tamanho da janela a ser criada
  glutInitWindowSize (256, 256); 
  /*Estabelece a posição inicial do canto superior esquerdo da 
  janela a ser criada*/
  glutInitWindowPosition (100, 100); 
  //Cria uma janela com o nome especificado
  glutCreateWindow ("Preenchendo regiões");
  init();
  // Inicializar Callbacks
  glutDisplayFunc(display); 
  //Interagir com o teclado
  glutKeyboardFunc(keyboard);
  //Interagir com o mouse
  glutMouseFunc(mouse);
  //Renderiza a cena e aguarda interaÃ§Ãµes
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
  // Desabilita a mascara de preenchimento pré-definida [Tux]
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

  // Imprime na tela um poligono em degradÃª
  glBegin(GL_POLYGON);
    glColor3f(1.0, 0.0, 0.0);  glVertex2i(30,113);  
    glColor3f(0.0, 1.0, 0.0);  glVertex2i(113,113);
    glColor3f(0.0, 0.0, 1.0);  glVertex2i(113,30);  
    glColor3f(1.0, 1.0, 0.0);  glVertex2i(30,30); 
  glEnd();

  // Abilita a mascara de preenchimento prédefinida [Tux]
  glEnable(GL_POLYGON_STIPPLE);
  glColor3f(1.0, 0.0, 1.0);
  glPolygonStipple(tux);

  // Imprime na tela um poligono com a máscara de [Tux]
  glBegin(GL_POLYGON);
    glVertex2i(143,113); glVertex2i(226,113);
    glVertex2i(226,30); glVertex2i(143,30); 
  glEnd();

  glFlush();
  /* é usada no lugar da glFlush porque quando é feita a 
  troca (ou swap) de buffers, é realizada implicitamente uma 
  operaçãoo de flush. Esta funãoo continua fazendo o flush 
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
    - button define o botão que foi clicado no mouse
    - state define 
    - x e y são coordenada do mouse no momento da 
      interaçao do */
  switch (button) {
    case GLUT_LEFT_BUTTON:
    	if (state == GLUT_DOWN) {
        // Gera uma nova combinaÃ§Ã£o de RGB randomicamente
    	  r=(GLfloat)rand()/(RAND_MAX+1.0);
    	  g=(GLfloat)rand()/(RAND_MAX+1.0);
    	  b=(GLfloat)rand()/(RAND_MAX+1.0);
    	  /* a funçao display é chamada novamente, fazendo 
        com que a janela corrente seja redesenhada */
        glutPostRedisplay(); 
    	}
    	break;
  }
}