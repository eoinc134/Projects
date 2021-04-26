#include "mainwindow.h"
#include <QApplication>

union {
   unsigned int type : 1; // [0]: GUI, [1]: CLI
} Run;


int main(int argc, char *argv[])
{
    Run.type = 1;

    if(Run.type == 0){
        QApplication a(argc, argv);
        MainWindow game;
        game.show();
        return a.exec();
    } else {
        CLI game;
        game.start();
        return 0;
    }

}

