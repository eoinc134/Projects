#include "Room.h"

Room::Room(string name) : npc(NPC(" ", 0, false, 0, " ")){
    this->name = name;
}

string Room::getName(){
    return this->name;
}
Room* Room::getNextRoom(string direction){
    map<string, Room*>::iterator next = exits.find(direction);
    if (next == exits.end()){
        return NULL;
    }
    return next->second;
}
string Room::getItemsInRoom(){
    if(itemsInRoom.size() > 0){
        string output = " The items in the room are: \n ";

        for(int n = 0; n < (int) itemsInRoom.size(); n++){
            output += ((itemsInRoom[n].getItem()) + " ");
        }
        return output;
    }
    return " There are no items here";
}

void Room::setExits(Room *north, Room *south, Room *east, Room *west)
{
    if(north != NULL){
        exits["north"] = north;
    } if(south != NULL){
        exits["south"] = south;
    } if(east != NULL){
        exits["east"] = east;
    } if(west != NULL){
        exits["west"] = west;
    }
}

bool Room::inRoom(string itemName){
    for(int n = 0; n < (int) itemsInRoom.size(); n++){
        if(itemName.compare(itemsInRoom[n].getItem()) == 0){
            return true;
        }
    }
    return false;
}
void Room::addItem(Item item){
    itemsInRoom.push_back(item);
}
Item Room::takeItem(string itemName){
    for(int n = 0; n < (int) itemsInRoom.size(); n++){
        if(itemName.compare(itemsInRoom[n].getItem()) == 0){
            return itemsInRoom[n];
        }
    }
    return Item("","",0,0,false,false);
}
void Room::removeItem(string itemName){
    for(int n = 0; n < (int) itemsInRoom.size(); n++){
        if(itemName.compare(itemsInRoom[n].getItem()) == 0){
            itemsInRoom.erase(itemsInRoom.begin() + n);
        }
    }
}

void Room::addNPC(NPC npc){
    this->npc = npc;
 }
NPC Room::getNPC(){
    return this->npc;
}
void Room::setNPCHealth(int health){
    this->npc.setHealth(health);
}

void Room::removeNPC(){
    npc.setName(" ");
    npc.setHostility(false);
}

bool Room::inHouse(string name){
    if(name.compare("house") == 0 || name.compare("kitchen") == 0 || name.compare("bedroom") == 0 || name.compare("livingRoom") == 0){
        return true;
    }
    return false;
}

void Room::spawn(){
    int r = (rand() % 100);

    if(r >= 40 && r < 50){
        addItem(Item("coin", "A shiny coin", 10, 1, false, false));
    } else if(r >= 30 && r < 40){
        addItem(Item("bread", "A lump of bread", 10, 1, false, true));
    }


    if(name.compare("start") == 0 || name.compare("meadow") == 0 || inHouse(name)) {
         // do nothing
     } else {
        if(npc.getName().compare(" ") == 0){
            if(r < 10){
                addNPC(NPC("Goblin", 20, true, 5, "GRAHGHGGH"));
            } else if(r >= 10 && r < 20){
                addNPC(NPC("Bat", 10, true, 1, "*squeak*"));
            }
        }
    }
}
