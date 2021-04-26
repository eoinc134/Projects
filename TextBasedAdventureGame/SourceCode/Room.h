#ifndef ROOM_H
#define ROOM_H

#include "Item.h"
#include "NPC.h"
#include <string>
#include <vector>
#include <map>
#include <iostream>
#include <stdlib.h>
#include <stdio.h>
using namespace std;


class Room{
    private:
        string name;
        map<string, Room*> exits;
        vector<Item> itemsInRoom;
        NPC npc;

    public:
        Room(string name);
        string getName();
        Room* getNextRoom(string direction);
        void setExits(Room *north, Room *south, Room *east, Room *west);

        void addItem(Item item);
        string getItemsInRoom();
        bool inRoom(string itemName);
        Item takeItem(string itemName);
        void removeItem(string itemName);

        void addNPC(NPC npc);
        NPC getNPC();
        void setNPCHealth(int health);
        bool inRoom();
        void removeNPC();

        bool inHouse(string name);

        void spawn();

        friend class CLI;
        friend class MainWindow;
};

#endif // ROOM_H
