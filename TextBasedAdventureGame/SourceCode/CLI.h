#ifndef CLI_H
#define CLI_H

#include "Command.h"
#include "StringInputCLI.h"
#include "Room.h"
#include "RoomDescriptions.h"
#include "Player.h"
#include "Character.h"
#include "Item.h"
#include "Shop.h"
#include <iostream>
#include "mainwindow.h"
using namespace std;

class CLI
{
    private:
        Player user;
        Room *currentRoom;
        Room *exit, *cave2;
        StringInputCLI input;
        bool won, quit;

        void loadMap();
        void printWelcome();
        void printHelp();
        void goDirection(string direction);
        bool validDirection(string direction);
        bool commandAction(Command command);
        void useItem(Item item);
        int interact(NPC npc);
        bool gameOver(bool quit, bool won, int health);

    public:
        CLI();
        void start();

};

#endif // CLI_H
