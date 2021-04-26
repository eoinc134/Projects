#ifndef MAINWINDOW_H
#define MAINWINDOW_H

#include <QMainWindow>
#include <stdlib.h>
#include "Character.h"
#include "Command.h"
#include "Item.h"
#include "NPC.h"
#include "Player.h"
#include "Room.h"
#include "RoomDescriptions.h"
#include "Shop.h"
#include "StringInputGUI.h"
#include "ValidCommands.h"
#include "CLI.h"
#include "GetMin.cpp"
#include "LuckyLedge.h"

QT_BEGIN_NAMESPACE
namespace Ui { class MainWindow; }
QT_END_NAMESPACE

class MainWindow : public QMainWindow
{
    Q_OBJECT

public:
    MainWindow(QWidget *parent = nullptr);
    ~MainWindow();

     Ui::MainWindow *ui;
     void start();

private slots:
     void on_pushButton_north_clicked();
     void on_pushButton_west_clicked();
     void on_pushButton_south_clicked();
     void on_pushButton_east_clicked();

     void on_pushButton_map_clicked();
     void on_pushButton_search_clicked();
     void on_pushButton_inventory_clicked();
     void on_pushButton_quit_clicked();

     void on_pushButton_examine_clicked();
     void on_pushButton_buy_clicked();
     void on_pushButton_use_clicked();
     void on_pushButton_take_clicked();
     void on_pushButton_drop_clicked();

private:
     Player user;
     Room *currentRoom;
     Room *exit, *cave2;
     StringInputGUI input;
     bool won, quit;
     bool easterEgg = true;

     void loadMap();
     void printWelcome();
     void goDirection(string direction);
     bool validDirection(string direction);
     bool commandAction(Command command);
     void useItem(Item item);
     int interact(NPC npc);
     void setUpRoom();
     bool gameOver(bool quit, bool won, int health);
};
#endif // MAINWINDOW_H
