/*
Utiliza a funÁao glutTimeFunc() para determinar a velocidade e loop para os quadrados
 subirem e decerem.
*/

#include <iostream>
#include <GL/glut.h>
#include <vector>

using namespace std;

int H;
int W;


typedef struct ponto
{
  int x;
  int y;

} Ponto;

typedef struct retangulo
{
  Ponto p1, p2, p3, p4;
  bool estaNoTopo;//controla os retangulos quando chegarem no topo e quando tiverem baixados.
} Retangulo;

vector<Retangulo> pessoalDaOla;

//cria as coordenadas dos 6 retangulos
void criaRetangulos()
{
  Retangulo rec;
  int d_x = W/6;
  int d_y = H/6;


    for(unsigned int ix = 0; ix < 6; ix++)
    {
      rec.p1.x = ix*d_x; rec.p1.y = 0;
      cout<< rec.p1.x << " " << rec.p1.y << endl;
      rec.p2.x = ix*d_x + d_x; rec.p2.y = 0;
      cout<< rec.p2.x << " " << rec.p2.y << endl;
      rec.p3.x = ix*d_x + d_x; rec.p3.y = d_y;
      cout<< rec.p3.x << " " << rec.p3.y << endl;
      rec.p4.x = ix*d_x; rec.p4.y = d_y;
      cout<< rec.p4.x << " " << rec.p4.y << endl;
      rec.estaNoTopo = false;
      pessoalDaOla.push_back(rec);

    }
}

//desenha os 6 retangulos
void desenhaRetangulos()
{
  glLineWidth(3);
  for(unsigned int i= 0; i<pessoalDaOla.size(); ++i)
  {
    glColor3f(0, (double)i/pessoalDaOla.size(), (double)i/pessoalDaOla.size());
    glBegin(GL_QUADS);
      glVertex2f(pessoalDaOla[i].p1.x, pessoalDaOla[i].p1.y);
      glVertex2f(pessoalDaOla[i].p2.x, pessoalDaOla[i].p2.y);
      glVertex2f(pessoalDaOla[i].p3.x, pessoalDaOla[i].p3.y);
      glVertex2f(pessoalDaOla[i].p4.x, pessoalDaOla[i].p4.y);
    glEnd();
  }
}

//executa o algoritmo do ola, de subir e decerem os quadrados.
void atualizar(int tempo)
{
    if (!pessoalDaOla[0].estaNoTopo)//1∫ quadrado
    {
      pessoalDaOla[0].p1.y += 5;
      pessoalDaOla[0].p2.y += 5;
      pessoalDaOla[0].p3.y += 5;
      pessoalDaOla[0].p4.y += 5;

      if (pessoalDaOla[0].p3.y > 200 ) pessoalDaOla[0].estaNoTopo = true;//quando chega a 1/3 de altura da tela
    }
    else if(!pessoalDaOla[1].estaNoTopo)//2∫ quadrado 
    {
      pessoalDaOla[1].p1.y += 5;
      pessoalDaOla[1].p2.y += 5;
      pessoalDaOla[1].p3.y += 5;
      pessoalDaOla[1].p4.y += 5;

      if (pessoalDaOla[1].p3.y > 200 ) pessoalDaOla[1].estaNoTopo = true;//quando chega a 1/3 de altura da tela
     }
    
    else if(!pessoalDaOla[2].estaNoTopo)//3∫ quadrado
    {
      pessoalDaOla[2].p1.y += 5;
      pessoalDaOla[2].p2.y += 5;
      pessoalDaOla[2].p3.y += 5;
      pessoalDaOla[2].p4.y += 5;

      if (pessoalDaOla[2].p3.y > 200 ) pessoalDaOla[2].estaNoTopo = true;//quando chega a 1/3 de altura da tela
      
    }

    else if(!pessoalDaOla[3].estaNoTopo)//4¬∫ quadrado
    {
      pessoalDaOla[3].p1.y += 5;
      pessoalDaOla[3].p2.y += 5;
      pessoalDaOla[3].p3.y += 5;
      pessoalDaOla[3].p4.y += 5;

      if (pessoalDaOla[3].p3.y > 200 ) pessoalDaOla[3].estaNoTopo = true;//quando chega a 1/3 de altura da tela
    }

    else if(!pessoalDaOla[4].estaNoTopo)//5∫ quadrado
    {
      pessoalDaOla[4].p1.y += 5;
      pessoalDaOla[4].p2.y += 5;
      pessoalDaOla[4].p3.y += 5;
      pessoalDaOla[4].p4.y += 5;

      if (pessoalDaOla[4].p3.y > 200 ) pessoalDaOla[4].estaNoTopo = true;//quando chega a 1/3 de altura da tela
     }

     else if(!pessoalDaOla[5].estaNoTopo)//6∫ quadrado
    {
      pessoalDaOla[5].p1.y += 5;
      pessoalDaOla[5].p2.y += 5;
      pessoalDaOla[5].p3.y += 5;
      pessoalDaOla[5].p4.y += 5;

      if (pessoalDaOla[5].p3.y > 200 ) pessoalDaOla[5].estaNoTopo = true;//quando chega a 1/3 de altura da tela
     }

     //desce todos os quadrados at√© os ret√¢ngulos chegarem em 0, 
     else
     {
      pessoalDaOla[0].p1.y -= 5;
      pessoalDaOla[0].p2.y -= 5;
      pessoalDaOla[0].p3.y -= 5;
      pessoalDaOla[0].p4.y -= 5;
      if (pessoalDaOla[0].p1.y <= 0) pessoalDaOla[0].estaNoTopo = false;

      pessoalDaOla[1].p1.y -= 5;
      pessoalDaOla[1].p2.y -= 5;
      pessoalDaOla[1].p3.y -= 5;
      pessoalDaOla[1].p4.y -= 5;
      if (pessoalDaOla[1].p1.y <= 0) pessoalDaOla[1].estaNoTopo = false;

      pessoalDaOla[2].p1.y -= 5;
      pessoalDaOla[2].p2.y -= 5;
      pessoalDaOla[2].p3.y -= 5;
      pessoalDaOla[2].p4.y -= 5;
      if (pessoalDaOla[2].p1.y <= 0) pessoalDaOla[2].estaNoTopo = false;

      pessoalDaOla[3].p1.y -= 5;
      pessoalDaOla[3].p2.y -= 5;
      pessoalDaOla[3].p3.y -= 5;
      pessoalDaOla[3].p4.y -= 5;
      if (pessoalDaOla[3].p1.y <= 0) pessoalDaOla[3].estaNoTopo = false;

      pessoalDaOla[4].p1.y -= 5;
      pessoalDaOla[4].p2.y -= 5;
      pessoalDaOla[4].p3.y -= 5;
      pessoalDaOla[4].p4.y -= 5;
      if (pessoalDaOla[4].p1.y <= 0) pessoalDaOla[4].estaNoTopo = false;

      pessoalDaOla[5].p1.y -= 5;
      pessoalDaOla[5].p2.y -= 5;
      pessoalDaOla[5].p3.y -= 5;
      pessoalDaOla[5].p4.y -= 5;
      if (pessoalDaOla[5].p1.y <= 0) pessoalDaOla[5].estaNoTopo = false;

     }
    
   glutPostRedisplay();
}

void opengl()
{
  glClear(GL_COLOR_BUFFER_BIT);

  desenhaRetangulos();
  glutTimerFunc(50, atualizar, 0);

  glutSwapBuffers();
}


void init()
{
  
  

  glClearColor(1, 1, 1, 0);
  glMatrixMode(GL_MODELVIEW); 
  glLoadIdentity();
  gluOrtho2D(0, 900, 0, 600);

  H = glutGet(GLUT_WINDOW_HEIGHT);
  W = glutGet(GLUT_WINDOW_WIDTH);
  criaRetangulos();
}


int main(int argc, char** argv)
{
  glutInit(&argc, argv);
  

  glutInitWindowSize(900, 600);
  glutInitWindowPosition(0, 0);
  glutCreateWindow("Projeto OLA!");
  glutInitDisplayMode(GL_RGB);
  init();

  glutDisplayFunc(opengl);
  glutMainLoop();
  
  return EXIT_SUCCESS;
}
