#include <QCoreApplication>
#include <iostream>
#include <stdlib.h>
using namespace std;

#include "CLI.h"

CLI::CLI(){
    loadMap();
}

void CLI::loadMap(){
    Room *start, *crossroads, *house, *kitchen, *bedroom, *livingRoom, *meadow;
    Room *forestPath, *forest1, *forest2, *forest3, *forest4, *forest5;
    Room *westPath, *treasureTrove;
    Room *eastPath, *caveEntrance, *cave1, *cave3, *cave4, *cave5, *cave6, *cave7, *cave8, *cave9;
    Room *southPath, *finalBoss, *bridge, *mountainPath, *mountain1, *mountain2, *mountain3;

    //create rooms
    start            = new Room("start");
    crossroads       = new Room("crossroads");
    house            = new Room("house");
    kitchen          = new Room("kitchen");
    bedroom          = new Room("bedroom");
    livingRoom       = new Room("livingRoom");
    meadow           = new Room("meadow");
    forestPath       = new Room("forestPath");
    forest1          = new Room("forest1");
    forest2          = new Room("forest2");
    forest3          = new Room("forest3");
    forest4          = new Room("forest4");
    forest5          = new Room("forest5");
    westPath         = new Room("westPath");
    treasureTrove    = new Room("treasureTrove");
    eastPath         = new Room("eastPath");
    caveEntrance     = new Room("caveEntrance");
    cave1            = new Room("cave1");
    cave2            = new Room("cave2");
    cave3            = new Room("cave3");
    bridge           = new Room("bridge");
    cave4            = new Room("cave4");
    cave5            = new Room("cave5");
    cave6            = new Room("cave6");
    cave7            = new Room("cave7");
    cave8            = new Room("cave8");
    cave9            = new Room("cave9");
    southPath        = new Room("southPath");
    finalBoss        = new Room("finalBoss");
    mountainPath     = new Room("mountainPath");
    mountain1        = new Room("mountain1");
    mountain2        = new Room("mountain2");
    mountain3        = new Room("mountain3");
    exit             = new Room("exit");

    //cout << "setting exits" << endl;
    //set exits(N/S/E/W)
    start           ->setExits(house, crossroads, NULL, NULL);
    crossroads      ->setExits(start, southPath, eastPath, westPath);
    house           ->setExits(kitchen, start, bedroom, NULL);
    kitchen         ->setExits(NULL, house, livingRoom, forestPath);
    bedroom         ->setExits(NULL, NULL, NULL, house);
    livingRoom      ->setExits(meadow, NULL, NULL, kitchen);
    meadow          ->setExits(NULL, livingRoom, NULL, forest5);
    forestPath      ->setExits(forest5, forest1, kitchen, forest3);
    forest1         ->setExits(forestPath, NULL, NULL, forest2);
    forest2         ->setExits(forest3, NULL, forest1, NULL);
    forest3         ->setExits(forest4, forest2, forestPath, NULL);
    forest4         ->setExits(NULL, forest3, forest5, NULL);
    forest5         ->setExits(NULL, forestPath, meadow, forest4);
    westPath        ->setExits(NULL, NULL, crossroads, treasureTrove);
    treasureTrove   ->setExits(NULL, NULL, westPath, NULL);
    eastPath        ->setExits(NULL, NULL, caveEntrance, crossroads);
    caveEntrance    ->setExits(NULL, NULL, NULL, eastPath);
    cave1           ->setExits(NULL, NULL, NULL, cave2);
    cave2           ->setExits(NULL, caveEntrance, cave1, cave3);
    cave3           ->setExits(cave4, NULL, cave2, NULL);
    cave4           ->setExits(cave5, cave3, NULL, NULL);
    cave5           ->setExits(NULL, cave4, cave6, NULL);
    cave6           ->setExits(NULL, NULL, cave7, cave5);
    cave7           ->setExits(NULL, cave8, NULL, cave6);
    cave8           ->setExits(cave7, cave1, NULL, cave9);
    cave9           ->setExits(NULL, NULL, cave8, NULL);
    southPath       ->setExits(crossroads, NULL, mountainPath, finalBoss);
    finalBoss       ->setExits(NULL, NULL, southPath, bridge);
    bridge          ->setExits(NULL, NULL, finalBoss, NULL);
    mountainPath    ->setExits(NULL, NULL, mountain1, southPath);
    mountain1       ->setExits(NULL, NULL, mountain2, mountainPath);
    mountain2       ->setExits(mountain3, NULL, NULL, mountain1);
    mountain3       ->setExits(NULL, mountain2, NULL, NULL);

    //add items [name, description, value, isWeapon, isEdible]
    forest4->addItem(Item("sword", "An ancient longsword", 50, 50, true, false));
    kitchen->addItem(Item("knife", "A large kitchen knife", 10, 5, true, false));

    house->addItem(Item("bread", "A small loaf of bread", 5, 1, false, true));
    cave4->addItem(Item("alcohol", "A large bottle of alcohol", 10, 10, false, true));

    forest5->addItem(Item("coin", "A large gold coin", 15, 1, false, false));
    westPath->addItem(Item("coin", "A large silver coin", 10, 1, false, false));
    cave1->addItem(Item("coin", "A large gold coin", 15, 1, false, false));
    mountain1->addItem(Item("coin", "A large silver coin", 10, 1, false, false));
    treasureTrove->addItem(Item("coins", "A mound of coins", 30, 1, false, false));

    bridge->addItem(Item("key", "It must unlock something...", 10, 5, false, false));

    forest2->addItem(Item("lamp", "A rusty old lamp", 10, 20, false, false));
    //cave7->addItem(Item("armour", "This armour protects you from fire damage", 50, 50, false, false));


    //add NPCs and Enemies
    forest3->addNPC(NPC("Dwarf", 20, false, 0, "Hello Traveller"));
    meadow->addNPC(NPC("Dog", 20, false, 0, "Woof!"));

    cave8->addNPC(NPC("Spider", 30, true, 5, "sssssssss"));
    //finalBoss->addNPC(NPC("Dragon", 100, true, 15, "RRRAAAWRRR!!!"));

    currentRoom = start;
}

void CLI::start(){
    printWelcome();

    quit = won = false;
    while(gameOver(quit, won, user.getHealth())) {
        cout << " Health: " << user.getHealth() << endl;
        cout << " Coins: " << user.getCoins() << endl;
        Command command = input.getCommand();
        quit = commandAction(command);
        user.setHealth(user.getHealth() - interact(currentRoom->npc));
    }
}

void CLI::printWelcome(){
    cout << " Welcome to Beyond the South East" << endl;
    cout << " By Sean Ryan and Eoin Costello" << endl;
    cout << endl;

    cout << RoomDescriptions::getDescription(currentRoom->name) << endl;
    cout << endl;
    cout << " type >help< for command list" << endl;
    cout << endl;
}
void CLI::printHelp(){
    cout << " Valid Commands are: " << endl;
    input.showCommands();
}

bool CLI::commandAction(Command command){
    cout << endl;
    string commandStr = command.getFirstWord();
    string secondWord = command.getSecondWord();

    if(commandStr.compare("quit") == 0){
        return true;

    } else if(commandStr.compare("help") == 0){
        printHelp();

    } else if(commandStr.compare("map") == 0){
       if(currentRoom->inHouse(currentRoom->name)){
           cout << "                          ::MAP::                   " << endl;
           cout << endl;
           cout << "                                     >to meadow<    " << endl;
           cout << "                                          |         " << endl;
           cout << " >to forest path< -- [Kitchen] ----  [LivingRoom]   " << endl;
           cout << "                         |                          " << endl;
           cout << "                         |                          " << endl;
           cout << "                      [House]  ----   [Bedroom]     " << endl;
           cout << "                         |                          " << endl;
           cout << "                     >to start<                     " << endl;
           cout << endl;
           cout << " Current Location-> " << currentRoom->name << endl;
           cout << endl;
       } else {
            cout << "                                      ::MAP::                                                     " << endl;
            cout << endl;
            cout << "    [Forest4] ----  [Forest5]  ----- [Meadow]              [Cave5] --- [Cave6] --- [Cave7]        " << endl;
            cout << "        |               |                |                    |                       |           " << endl;
            cout << "        |               |                |                    |                       |           " << endl;
            cout << "    [Forest3] ---- [ForestPath] ----- [House]              [Cave4]     [Cave9] --- [Cave8]        " << endl;
            cout << "        |               |                |                    |                       |           " << endl;
            cout << "        |               |                |                    |                       V           " << endl;
            cout << "    [Forest2] ---- [Forest1]          [Start]              [Cave3] --- [Cave2] --- [Cave1]        " << endl;
            cout << "                                         |                                |                       " << endl;
            cout << "                                         |                                |                       " << endl;
            cout << " [TreasureTrove] --- [WestPath] --- [Crossroads] --- [EastPath] --- [CaveEntrance]     [Mountain3]" << endl;
            cout << "                                         |                                                  |     " << endl;
            cout << "                                         |                                                  |     " << endl;
            cout << "       [Bridge] --- [FinalBoss] --- [SouthPath] --- [MountainPath] --- [Mountain1] --- [Mountain2]" << endl;
            cout << endl;
            cout << " Current Location-> " << currentRoom->name << endl;
            cout << endl;
       }

    } else if(commandStr.compare("go") == 0){
        if((currentRoom->npc).isHostile()){
            cout << " There are hostile enemies nearby" << endl;
        } else {
            goDirection(secondWord);
        }

    } else if(commandStr.compare("search") == 0){
        cout << currentRoom->getItemsInRoom() << endl;

    } else if(commandStr.compare("take") == 0){
        if(currentRoom->inRoom(secondWord)){
            Item a = currentRoom->takeItem(secondWord);
            if(user.isFull(a.getWeight())){
                cout << " Inventory is full: " << user.items() << endl;
            } else {
                if(secondWord.compare("coin") == 0 || secondWord.compare("coins") == 0){
                    user.addCoins(a);
                } else {
                    user.takeItem(a);
                }

                currentRoom->removeItem(secondWord);
                cout << " You took the: " << secondWord << endl;
                cout << " Inventory:    " << user.items() << endl;
            }
        } else if(secondWord == ""){
            cout << " Please specify an item" << endl;
        } else {
            cout << " Could not find: " << secondWord << endl;
        }


    } else if(commandStr.compare("drop") == 0){
        if(secondWord.compare("coins") == 0){
            cout << " You cannot drop these" << endl;

        } else if(user.hasItem(secondWord)){
            Item a = user.getItem(secondWord);
            currentRoom->addItem(a);
            user.removeItem(secondWord);

            cout << " Dropped:   " << secondWord << endl;
            cout << " Inventory: " << user.items() << endl;
        } else if(secondWord == ""){
            cout << " Please specify an item" << endl;

        } else {
            cout << secondWord << " is not in inventory" << endl;
        }


    } else if(commandStr.compare("examine") == 0){
        if(user.hasItem(secondWord)){
           (user.getItem(secondWord)).examineItem();
        } else if(secondWord == ""){
            cout << " Please specify an item" << endl;
        } else {
            cout << " " << secondWord << " is not in inventory" << endl;
        }

    } else if(commandStr.compare("use") == 0){
        if(user.hasItem(secondWord)){
            useItem(user.getItem(secondWord));
        } else if(secondWord == ""){
            cout << " Please specify an item" << endl;
        } else {
            cout << " " << secondWord << " is not in inventory" << endl;
        }

    } else if(commandStr.compare("buy") == 0){
        if(currentRoom->npc.getName().compare("Dwarf") == 0){
            if(currentRoom->npc.hasItem(secondWord)){
                Item i = currentRoom->npc.getItem(secondWord);
                if(user.getCoins() > i.getValue()){
                    currentRoom->addItem(currentRoom->npc.getItem(secondWord));
                    user.removeCoins(i);
                    currentRoom->npc.removeItem(secondWord);

                    cout << " You bought: " << secondWord << endl;
                    cout << " Please 'take' your new item" << endl;
                } else {
                    cout << " You do not have enough money" << endl;
                }

            } else if(secondWord == ""){
                cout << " Please specify an item" << endl;
            } else {
                cout << " Shop does not have: " << secondWord << " in stock" << endl;
            }
        } else {
            cout << " There is no shop here" << endl;
        }

    } else if(commandStr.compare("") == 0){
        cout << " ENTER A VALID COMMAND" << endl;
    }
    cout << endl;
    return false;
}

void CLI::goDirection(string direction){
    if(validDirection(direction)){
        Room* nextRoom = currentRoom->getNextRoom(direction);
        if(nextRoom != NULL){
            if(currentRoom->name.compare("caveEntrance") == 0 && user.hasItem("lamp") == false && direction.compare("north") == 0){
                cout << " The cave is too dark to enter" << endl;
            } else {
                currentRoom = nextRoom;
                cout << " - " << currentRoom->name << " -" << endl;
                cout << RoomDescriptions::getDescription(currentRoom->name) << endl;

                currentRoom->spawn();
                if(currentRoom->name.compare("cave7") == 0){
                    user.setHealth(user.getHealth() / 2);
                }
                if(currentRoom->name.compare("cave4") == 0 && direction.compare("north") == 0){
                    int r = (rand() % 100);
                    if(r > 50){
                        user.setHealth(user.getHealth() - 10);
                        cout << "\n The plank below you snaps! " << endl;
                        cout << " You can climb back up to the north or south" << endl;
                        cout << " -10 Health" << endl;
                    }

                }
                if(currentRoom->name.compare("exit") == 0){won = true;}
            }
        } else {
            cout << " You cannot go this direction" << endl;
        }
    } else {
        cout << " Please enter valid direction" << endl;
    }
}

bool CLI::validDirection(string dir){
    if(dir == "north"){
        return true;
    } else if(dir == "south"){
        return true;
    } else if(dir =="east"){
        return true;
    } else if(dir == "west"){
        return true;
    }
    return false;
}

void CLI::useItem(Item item){
    if(item.isWeapon()){
        if(((currentRoom->npc).getName()).compare(" ") != 0 && currentRoom->npc.getHealth() > 0){
            int health = (currentRoom->npc.getHealth()) - item.getValue();
            currentRoom->setNPCHealth(health);
            cout << " You attacked " << (currentRoom->npc).getName() << " with the " << item.getItem() << endl;
            cout << " " << currentRoom->npc.getName() << "-> Health: " << currentRoom->npc.getHealth() << endl;
            if(health <= 0){
                cout << " " <<(currentRoom->npc).getName();
                cout << " was slain" << endl;
                currentRoom->removeNPC();
            }
        } else {
            cout << " There are no enemies here" << endl;
        }

    } else if(item.isEdible()){
        user.setHealth(user.getHealth() + item.getValue());
        user.removeItem(item.getItem());
        cout << " You used the " << item.getItem() <<  "-> +" << item.getValue() << " health" << endl;

    } else if(item.getItem() == "key"){
        if(currentRoom->name.compare("bridge") == 0){
            currentRoom->setExits(NULL, NULL, NULL, exit);
            cout << " HUZZAH! The path is unlocked\n You can now leave the island" << endl;

        } else {
            cout << " You cannot use that here" << endl;
        }

    } else if(item.getItem() == "lamp"){
        if(currentRoom->name.compare("caveEntrance") == 0){
            currentRoom->setExits(cave2, NULL, NULL, NULL);
            cout << " With the lamp illuminating your way you may now enter the cave" << endl;

        } else {
            cout << " You cannot use that here" << endl;
        }

    } else if(item.getItem() == "armour"){
        cout << "used armour" << endl;

    } else if(item.getItem() == "coins"){
        cout << " Coins can be used to buy items" << endl;
        cout << " Try buying an item from a shop" << endl;
    }
}

int CLI::interact(NPC npc){
    if(npc.getName() != "" && npc.getHealth() > 0){
        if(npc.isHostile()){
            cout << " You are attacked by: " << npc.getName() << " [" << (npc.getHealth()) << " health]" << endl;
            cout << "                      ->'" << npc.getGreeting() << "'" << endl;
            cout << " -" << npc.getDamage() << " health" << endl;
            cout << endl;
            return npc.getDamage();
        } else if(npc.getName() == "Dwarf"){
            cout << " You meet: " << npc.getName() << endl;
            cout << " Welcome to my store!" << endl;
            cout << npc.getStock();
            cout << endl;
        } else {
            cout << " You meet: " << npc.getName() << endl;
            cout << "           '" << npc.getGreeting() << "'" << endl;
            cout << endl;
        }
    }
    return 0;
}

bool CLI::gameOver(bool quit, bool won, int health){
    if(quit){
        cout << " You quit the game" << endl;
        return false;
    } else if(won){
        cout << " You won" << endl;
        return false;
    } else if(health <=0){
        cout << " You died" << endl;
        return false;
    }
    return true;
}
