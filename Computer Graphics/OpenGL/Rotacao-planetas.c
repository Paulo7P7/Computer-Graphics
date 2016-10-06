/*
 * FreeGLUT Shapes Demo
 *
 * Written by Nigel Stewart November 2003
 *
 * This program is test harness for the sphere, cone 
 * and torus shapes in FreeGLUT.
 *
 * Spinning wireframe and smooth shaded shapes are
 * displayed until the ESC or q key is pressed.  The
 * number of geometry stacks and slices can be adjusted
 * using the + and - keys.
 */

#include <GL/glut.h>

#include <stdlib.h>
#include <iostream>


using namespace std;

static int year1 = 0, day = 0, year2 = 0, year3 = 0;

void init(void){
	glClearColor(0.0, 0.0, 0.0, 0.0);
}

void display(void){

	glClear(GL_COLOR_BUFFER_BIT);
	glColor3f(1.0, 0.0, 0.0);

	//planeta maior
	glPushMatrix();
	glColor3f(1.0f, 1.0f, 0.0f);
		glRotatef((GLfloat) year1, 1.0, 0.0, 0.0);
		glRotatef((GLfloat) day, 0.0, 0.0, 1.0);
		glutWireSphere(1.0, 20, 16);
		//http://www.opengl.org/documentation/specs/glut/spec3/node81.html
	glPopMatrix();

	glPushMatrix();
	glColor3f(0.0f, 0.0f, 1.0f);
		glRotatef((GLfloat) year1, 0.0, 1.0, 0.0);
		glTranslatef(2.0, 0.0, 0.0);
		glRotatef((GLfloat) day, 0.0, 1.0, 0.0);
		glutWireSphere(0.2, 15, 10);
	glPopMatrix();

	glPushMatrix();
	glColor3f(1.0f, 0.0f, 0.0f);
		glRotatef((GLfloat) year2, 0.0, 1.0, 0.0);
		glTranslatef(2.0, 0.0, 0.0);
		glRotatef((GLfloat) day, 0.0, 1.0, 0.0);
		glutWireSphere(0.2, 15, 10);
	glPopMatrix();


	glPushMatrix();
		glRotatef((GLfloat) year2, 0.0, 1.0, 0.0);
		glTranslatef(2.0, 0.0, 0.0);
		glRotatef((GLfloat) day, 0.0, 1.0, 0.0);
		
		glTranslatef(0.5, 0.0, 0.0);
		glRotatef((GLfloat) year2, 0.5, 0.0, 0.0);
		glTranslatef(0.5, 0.0, 0.0);

		glutWireSphere(0.09, 9, 6);
	glPopMatrix();

	glPushMatrix();
		glRotatef((GLfloat) year2, 0.0, 1.0, 0.0);
		glTranslatef(2.0, 0.0, 0.0);
		glRotatef((GLfloat) day, 0.0, 1.0, 0.0);
		
		glTranslatef(0.5, 0.0, 0.0);
		glRotatef((GLfloat) year2, 2.0, 1.5, 0.0);
		glTranslatef(0.5, 0.0, 0.0);

		glutWireSphere(0.09, 9, 6);
	glPopMatrix();


	
	glutSwapBuffers();
}

void reshape(int w, int h){

	glViewport(0, 0, (GLsizei) w, (GLsizei) h);

	glMatrixMode(GL_MODELVIEW);
	glLoadIdentity();

	gluPerspective(60.0, (GLfloat) w/(GLfloat) h, 1.0, 20.0);
	gluLookAt(0.0, 0.0, 5.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0);//http://www.opengl.org/sdk/docs/man2/xhtml/gluLookAt.xml

}

void keyboard(unsigned char key, int x, int y){

	switch(key){

		case 'd':
			day = (day + 10) % 360;
			glutPostRedisplay();
			break;
		case 'D':
			day = (day - 10) % 360;
			glutPostRedisplay();
			break;
		case 'y':
			year1 = (year1 + 5) % 360;
			year2 = (year2 - 5) % 360;
			year3 = (year3 - 5) % 360;
			glutPostRedisplay();
			break;
		case 'Y':
			year1 = (year1 - 5) % 360;
			year2 = (year2 + 5) % 360;
			year3 = (year3 - 5) % 360;
			glutPostRedisplay();
			break;
		case 27:
			exit(0);
			break;
		default:
			break;
	}
}
int main(int argc, char** argv)
{
	glutInit(&argc, argv);
	glutInitDisplayMode(GLUT_DOUBLE | GLUT_RGB);
	glutInitWindowSize(600, 600);
	glutInitWindowPosition(100, 100);
	glutCreateWindow("Rotacao de Planetas");
	init();
	glutDisplayFunc(display);
	glutReshapeFunc(reshape);
	glutKeyboardFunc(keyboard);
	glutMainLoop();

	return 0;
}
