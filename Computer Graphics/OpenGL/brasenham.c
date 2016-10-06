#include <iostream>
#include <GL/glut.h>
#include <vector>
#include <cmath>

using namespace std;


GLsizei winWidth = 800, winHeight = 600;

typedef struct ponto
{
	int x;
	int y;
}Ponto;

Ponto pontos;

vector<Ponto> pontosClick;




void init(void) {
	//Seta a cor da janela
	glClearColor(0.0, 0.0, 1.0, 1.0); 

	//Define a pilha de matrizes ativa, onde a matriz corrente � a //matriz de proje��o
	glMatrixMode (GL_PROJECTION);
	glLoadIdentity(); 

	//Altera a matriz de proje��o
	glOrtho(0.0, 200.0, 0.0, 150.0, -1.0, 1.0); 

	winHeight = glutGet(GLUT_WINDOW_HEIGHT);
	winWidth = glutGet(GLUT_WINDOW_WIDTH);

}

void displayFcn (void){

//Limpa a Tela e habilita os valores glClearColor
glClear (GL_COLOR_BUFFER_BIT); 

//Especifica a cor do ponto que vai ser desenhado na tela - cor //vermelha
glColor3f (1.0, 0.0, 0.0); 
//Determina a largura em pixels do ponto
glPointSize (2.0); 

 
  glFlush ();

}



void plotPoint (GLint x, GLint y) {

//Cria um ponto nas coordenadas x,y.

	cout << "x: " << x << " \ty: " << y << endl;

glBegin (GL_POINTS);
	glVertex2i (x,y);
glEnd();

}

void imprimirSequenciaPontos(GLint x1, GLint y1, GLint x2, GLint y2)
{
	int dx, dy, incE, incNE, d, x, y, a;


	dx = x2 - x1;
	if(y2 > y1)
	{
		a = 1;
		dy = y2 - y1;	
	}
	else
	{
		a = -1;
		dy = y1 - y2;
	}
	

	d = 2 * dy - dx;
	
	incE = 2 * dy;
	incNE = 2 * (dy - dx);

	x = x1;
	y = y1;
	plotPoint(x, y);

	while( x < x2)
	{
		if(d <= 0)//escolhe E
		{
			d = d + incE;
			x = x + 1;
		} else //escolhe NE
		{
			d = d + incNE;
			
			x += 1;
			y += a; 
		}
		plotPoint(x, y);
	}
}

void sequementoReta(GLint x1, GLint y1, GLint x2, GLint y2) // 
{
	/* A sequencia de IFs e ELSEs endentados separa os possíveis comportamentos no desenho do segmento de reta conforme coordenadas 
	recebida pelo método */
	if(x1 == x2)
		if(y1 == y2) // Pontos sobrepostos
			return; 
		else 
			if(y1 < y2) // Vetor no sentido Norte
			{
				int i = y1;
				while(i <= y2)
					plotPoint(x1,i++);
			}
			else //(y1 > y2) Vetor no sentido Sul
			{ 
				int i = y2;
				while(i <= y1)
					plotPoint(x1,i++);
			}
	else 
		if(x1 < x2)
			if(y1 < y2) // Vetor no sentido Nordeste
				imprimirSequenciaPontos(x1, y1, x2, y2);
			else 
				if(y1 > y2)  // Vetor no sentido Sudeste
					imprimirSequenciaPontos(x1, y1, x2, y2);
				else // (y1 == y2) Vetor no sentido Leste
				{
					int i = x1;
					while(i <= x2)
						plotPoint(i++, y1);
				}
		else // (x1 > x2)
			if(y1 < y2) // Vetor no sentido Noroeste
				imprimirSequenciaPontos(x2, y2, x1, y1);
			else 
				if(y1 > y2)  // Vetor no sentido Sudoeste
					imprimirSequenciaPontos(x2, y2, x1, y1);
				else // (y1==y2) Vetor no sentido Oeste
				{
					int i = x2;
					while(i <= x1)
						plotPoint(i++, y1);
				}
}

void mousePtPlot (GLint button, GLint action,
                                                GLint xMouse, GLint yMouse)
{
	int tamanho;
	
	if (button == GLUT_LEFT_BUTTON && action == GLUT_DOWN){
	//Pega posição x e y do mouse e passa como parâmetro a //função de desenhar o ponto na tela
		int x1= xMouse;
		int y1= winHeight - yMouse;
		pontos.x = x1;
		pontos.y = y1;
		pontosClick.push_back(pontos);
		//cout<<"x1 da funcao"<<winWidth<< " " << x1<<endl;
		//cout<<"y1 da funcao"<<winHeight<< " " <<y1<<endl;
		plotPoint (pontos.x, pontos.y);
		tamanho = pontosClick.size();
		//cout << tamanho << " " << pontosClick.size() <<  endl;
		if(tamanho >= 2)
		{
			//cout << pontosClick[0].x << " " << pontosClick[0].y << " " << pontosClick[1].x << " " <<  pontosClick[1].y << endl;
			sequementoReta(pontosClick[tamanho-2].x, pontosClick[tamanho-2].y, pontosClick[tamanho-1].x, pontosClick[tamanho-1].y);
			//sequementoReta(pontosClick[0].x, pontosClick[0].y, pontosClick[1].x, pontosClick[1].y);
		}                      
		//cout<<"x1 da funcao"<<winWidth<< " " << x1<<endl;
		//cout<<"y1 da funcao"<<winHeight<< " " <<y1<<endl;
		//cout << "tamanho vector:" << pontosClick.size() << endl ;
		//cout << "dad" << pontosClick[0].x << endl;
	}
	if (button == GLUT_RIGHT_BUTTON && action == GLUT_DOWN)
	{
		glColor3f(1.0, 1.0, 0.0);
		plotPoint(pontosClick[0].x, pontosClick[0].y);
		plotPoint(pontosClick[1].x, pontosClick[1].y);
	}
	glFlush();
}

void winReshapeFcn (GLint winWidth, GLint winHeight){

	//Define a pilha de matrizes ativa, onde a matriz corrente é a
	//matriz de projeção
	glMatrixMode (GL_PROJECTION);

	//Usado para inicializar a matriz topo da pilha ativa com a 
	//matriz identidade.
	glLoadIdentity();
	glOrtho (0.0, GLdouble (winWidth), 0.0, GLdouble (winHeight), -1.0, 1.0);

}

int main(int argc, char** argv) {

	//Inicialização do GLUT
	glutInit (&argc, argv);

	//Inicialização da janela - Estabelece o tipo de recurso necessário //para as janelas que serão criadas.
	glutInitDisplayMode(GLUT_SINGLE | GLUT_RGB);

	//Estabelece a posição inicial do canto superior esquerdo da 
	//janela a ser criada
	glutInitWindowPosition(100, 100);
	//Estabelece o tamanho da janela a ser criada
	glutInitWindowSize(winWidth, winHeight);
	//Cria uma janela com o nome especificado
	glutCreateWindow ("Pontos usando Mouse");

	//inicializa a janela de rendering
	//Inicializa e atribui parâmetros à view port
	init(); 
	// Inicializar Callbacks

	glutDisplayFunc(displayFcn);
	glutReshapeFunc (winReshapeFcn);

	//Interagir com o mouse
	glutMouseFunc(mousePtPlot);

	//Renderiza a cena e aguarda interações
	glutMainLoop();

	return 0;

}
