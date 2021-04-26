#include "mainwindow.h"
#include "ui_mainwindow.h"

MainWindow::MainWindow(QWidget *parent) : QMainWindow(parent), ui(new Ui::MainWindow){
    ui->setupUi(this);
    loadMap();
    start();
}

MainWindow::~MainWindow(){
    delete ui;
}

void MainWindow::loadMap(){
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
    cave4->addItem(Item("alcohol", "A large bottle of alcohol", -5, 10, false, true));

    forest5->addItem(Item("coin", "A large gold coin", 15, 1, false, false));
    westPath->addItem(Item("coin", "A large silver coin", 10, 1, false, false));
    cave1->addItem(Item("coin", "A large gold coin", 15, 1, false, false));
    mountain1->addItem(Item("coin", "A large silver coin", 10, 1, false, false));
    treasureTrove->addItem(Item("coins", "A mound of coins", 30, 1, false, false));

    cave9->addItem(Item("key", "It must unlock something...", 10, 5, false, false));

    forest2->addItem(Item("lamp", "A rusty old lamp", 10, 20, false, false));
    //cave7->addItem(Item("armour", "This armour protects you from fire damage", 50, 50, false, false));


    //add NPCs and Enemies
    forest3->addNPC(NPC("Dwarf", 20, false, 0, "Hello Traveller"));
    meadow->addNPC(NPC("Dog", 20, false, 0, "Woof!"));

    cave8->addNPC(NPC("Spider", 30, true, 5, "sssssssss"));
    finalBoss->addNPC(NPC("Dragon", 100, true, 15, "RRRAAAWRRR!!!"));

    currentRoom = start;
}


void MainWindow::setUpRoom(){
   if(gameOver(quit, won, user.getHealth())){
           user.setHealth(user.getHealth() - interact(currentRoom->npc));
            ui->textBrowser->append(QString::fromStdString( " Health: " + to_string(user.getHealth()) ));
            ui->textBrowser->append(QString::fromStdString( " Coins: " + to_string(user.getCoins()) ));
   } else {
       std::exit(0);
   }
}

void MainWindow::start(){
    printWelcome();
    quit = won = false;
}

void MainWindow::printWelcome(){
    Player x = Player(user.getName(), user.getHealth());
    Character *c = dynamic_cast<Character*>(&x);
    ui->textBrowser->append(QString::fromStdString( c->getGreeting() ));
    ui->textBrowser->append(QString::fromStdString(""));


   ui->textBrowser->append(QString::fromStdString(RoomDescriptions::getDescription(currentRoom->name)));
}

bool MainWindow::commandAction(Command command){
    ui->textBrowser->append(QString::fromStdString("" ));
    string commandStr = command.getFirstWord();
    string secondWord = command.getSecondWord();

    if(commandStr.compare("quit") == 0){
        return false;

    } else if(commandStr.compare("map") == 0){
       if(currentRoom->inHouse(currentRoom->name)){
           ui->textBrowser->append(QString::fromStdString( "\t\t::MAP::\t\t" ));
                      ui->textBrowser->append(QString::fromStdString(""));
                      ui->textBrowser->append(QString::fromStdString( ">                                                        to meadow<    " ));
                      ui->textBrowser->append(QString::fromStdString( "                                                                 |         " ));
                      ui->textBrowser->append(QString::fromStdString( " >to forest path< -- [Kitchen] ----  [LivingRoom]   " ));
                      ui->textBrowser->append(QString::fromStdString( "                                     |                           |  " ));
                      ui->textBrowser->append(QString::fromStdString( "                                     |                           | " ));
                      ui->textBrowser->append(QString::fromStdString( "                                 [House]  ----   [Bedroom]     " ));
                      ui->textBrowser->append(QString::fromStdString( "                                     |                          " ));
                      ui->textBrowser->append(QString::fromStdString( "                                >to start<                     " ));
                      ui->textBrowser->append(QString::fromStdString(""));
                      ui->textBrowser->append(QString::fromStdString( " Current Location-> " + currentRoom->getName() ));
                      ui->textBrowser->append(QString::fromStdString(""));
                  } else {
                       ui->textBrowser->append(QString::fromStdString( "                                      ::MAP::                                                     " ));
                       ui->textBrowser->append(QString::fromStdString(""));
                       ui->textBrowser->append(QString::fromStdString( "                   [Forest4] ----  [Forest5]  ----- [Meadow]            [Cave5] ---    [Cave6] --- [Cave7]          " ));
                       ui->textBrowser->append(QString::fromStdString( "                       |                       |                        |                         |                                          |             " ));
                       ui->textBrowser->append(QString::fromStdString( "                       |                       |                        |                         |                                          |             " ));
                       ui->textBrowser->append(QString::fromStdString( "                   [Forest3] ---- [ForestPath] ----- [House]            [Cave4]        [Cave9] --- [Cave8]           " ));
                       ui->textBrowser->append(QString::fromStdString( "                       |                       |                        |                         |                                          |" ));
                       ui->textBrowser->append(QString::fromStdString( "                       |                       |                        |                         |                                          V" ));
                       ui->textBrowser->append(QString::fromStdString( "                   [Forest2] ---- [Forest1]          [Start]            [Cave3]   -------   [Cave2] --- [Cave1]          " ));
                       ui->textBrowser->append(QString::fromStdString( "                                                                        |                                                  |                         " ));
                       ui->textBrowser->append(QString::fromStdString( "                                                                        |                                                  |                         " ));
                       ui->textBrowser->append(QString::fromStdString( "     [TreasureTrove] --- [WestPath] --- [Crossroads] --- [EastPath] --- [CaveEntrance]     [Mountain3]" ));
                       ui->textBrowser->append(QString::fromStdString( "                                                                        |                                                                             |     " ));
                       ui->textBrowser->append(QString::fromStdString( "                                                                        |                                                                             |     " ));
                       ui->textBrowser->append(QString::fromStdString( "       [Bridge] --- [FinalBoss] ---------- [SouthPath] --- [MountainPath] --- [Mountain1] --- [Mountain2]" ));
                       ui->textBrowser->append(QString::fromStdString(""));
                       ui->textBrowser->append(QString::fromStdString( " Current Location-> " + currentRoom->getName() ));
                       ui->textBrowser->append(QString::fromStdString(""));
                  }

    } else if(commandStr.compare("go") == 0){
        if((currentRoom->npc).isHostile()){
            ui->textBrowser->append(QString::fromStdString( " There are hostile enemies nearby" ));
        } else {
            goDirection(secondWord);
        }

    } else if(commandStr.compare("search") == 0){
        ui->textBrowser->append(QString::fromStdString( currentRoom->getItemsInRoom() ));

    } else if(commandStr.compare("take") == 0){
        if(currentRoom->inRoom(secondWord)){
            Item a = Item(currentRoom->takeItem(secondWord));
            if(user.isFull(a.getWeight())){
                ui->textBrowser->append(QString::fromStdString( " Inventory is full: " + user.items() ));
            } else {
                if(secondWord.compare("coin") == 0 || secondWord.compare("coins") == 0){
                    user.addCoins(a);
                } else {
                    user.takeItem(a);
                }

                currentRoom->removeItem(secondWord);
                ui->textBrowser->append(QString::fromStdString( " You took the: " + secondWord ));
                ui->textBrowser->append(QString::fromStdString( " Inventory:    " +user.items() ));
            }
        } else if(secondWord == ""){
            ui->textBrowser->append(QString::fromStdString( " Please specify an item" ));
        } else {
            ui->textBrowser->append(QString::fromStdString( " Could not find: " + secondWord ));
        }


    } else if(commandStr.compare("drop") == 0){
        if(secondWord.compare("coins") == 0){
            ui->textBrowser->append(QString::fromStdString( " You cannot drop these" ));

        } else if(user.hasItem(secondWord)){
            Item a = Item(user.getItem(secondWord));
            currentRoom->addItem(a);
            user.removeItem(secondWord);

            ui->textBrowser->append(QString::fromStdString( " Dropped:   " + secondWord ));
            ui->textBrowser->append(QString::fromStdString( " Inventory: " + user.items() ));
        } else if(secondWord == ""){
            ui->textBrowser->append(QString::fromStdString( " Please specify an item" ));

        } else {
            ui->textBrowser->append(QString::fromStdString( secondWord + " is not in inventory" ));
        }


    } else if(commandStr.compare("examine") == 0){
        if(user.hasItem(secondWord)){
            ui->textBrowser->append(QString::fromStdString((user.getItem(secondWord)).examineItem()));
        } else if(secondWord == ""){
            ui->textBrowser->append(QString::fromStdString( " Please specify an item" ));
        } else {
            ui->textBrowser->append(QString::fromStdString( " " + secondWord + " is not in inventory" ));
        }

    } else if(commandStr.compare("use") == 0){
        if(user.hasItem(secondWord)){
            useItem(user.getItem(secondWord));
        } else if(secondWord == ""){
            ui->textBrowser->append(QString::fromStdString( " Please specify an item" ));
        } else {
            ui->textBrowser->append(QString::fromStdString( " " + secondWord + " is not in inventory" ));
        }

    } else if(commandStr.compare("buy") == 0){
        if(currentRoom->npc.getName().compare("Dwarf") == 0){
            if(currentRoom->npc.hasItem(secondWord)){
                Item i = currentRoom->npc.getItem(secondWord);
                if(user.getCoins() > i.getValue()){
                    currentRoom->addItem(currentRoom->npc.getItem(secondWord));
                    user.removeCoins(i);
                    currentRoom->npc.removeItem(secondWord);

                    ui->textBrowser->append(QString::fromStdString( " You bought: " + secondWord ));
                    ui->textBrowser->append(QString::fromStdString( " Please 'take' your new item" ));
                } else {
                    ui->textBrowser->append(QString::fromStdString( " You do not have enough money" ));
                }

            } else if(secondWord == ""){
                ui->textBrowser->append(QString::fromStdString( " Please specify an item" ));
            } else {
                ui->textBrowser->append(QString::fromStdString( " Shop does not have: " + secondWord + " in stock" ));
            }
        } else {
            ui->textBrowser->append(QString::fromStdString( " There is no shop here" ));
        }

    } else if(commandStr.compare("") == 0){
        ui->textBrowser->append(QString::fromStdString( " ENTER A VALID COMMAND" ));
    }
    //ui->textBrowser->append(QString::fromStdString( endl;

    return true;
}

void MainWindow::goDirection(string direction){
    if(validDirection(direction)){
        Room* nextRoom = currentRoom->getNextRoom(direction);
        if(nextRoom != NULL){
            if(currentRoom->name.compare("caveEntrance") == 0 && user.hasItem("lamp") == false && direction.compare("north") == 0){
                ui->textBrowser->append(QString::fromStdString( " The cave is too dark to enter" ));
            } else {
                currentRoom = nextRoom;
                ui->textBrowser->append(QString::fromStdString( " - " + currentRoom->name + " -" ));
                ui->textBrowser->append(QString::fromStdString( RoomDescriptions::getDescription(currentRoom->name) ));

                currentRoom->spawn();
                if(currentRoom->name.compare("cave7") == 0){
                    user.setHealth(user.getHealth() / 2);
                }
                if(currentRoom->name.compare("cave4") == 0 && direction.compare("north") == 0){
                    int r = (rand() % 100);
                    if(r > 50){
                        user.setHealth(user.getHealth() - 10);
                        ui->textBrowser->append(QString::fromStdString( "\n The plank below you snaps! " ));
                        ui->textBrowser->append(QString::fromStdString( " You can climb back up to the north or south" ));
                        ui->textBrowser->append(QString::fromStdString( " -10 Health" ));
                    }

                }
                if(currentRoom->name.compare("exit") == 0){won = true;}
            }
        } else {
            ui->textBrowser->append(QString::fromStdString(" You cannot go this direction" ));
        }
    } else {
        ui->textBrowser->append(QString::fromStdString( " Please enter valid direction" ));
    }
}

bool MainWindow::validDirection(string dir){
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

void MainWindow::useItem(Item item){
    if(item.isWeapon()){
        if(((currentRoom->npc).getName()).compare(" ") != 0 && currentRoom->npc.getHealth() > 0){
            int health = (currentRoom->npc.getHealth()) - item.getValue();
            currentRoom->setNPCHealth(health);
            ui->textBrowser->append(QString::fromStdString( " You attacked " + (currentRoom->npc).getName() + " with the " + item.getItem() ));
            ui->textBrowser->append(QString::fromStdString( " " + (currentRoom->npc).getName() + "-> Health: " + to_string((currentRoom->npc).getHealth()) ));
            if(health <= 0){
                ui->textBrowser->append(QString::fromStdString( " " +(currentRoom->npc).getName()));
                ui->textBrowser->append(QString::fromStdString( " was slain" ));
                currentRoom->removeNPC();
            }
        } else {
            ui->textBrowser->append(QString::fromStdString( " There are no enemies here" ));
        }

    } else if(item.isEdible()){
        user.setHealth(user.getHealth() + item.getValue());
        user.removeItem(item.getItem());
        ui->textBrowser->append(QString::fromStdString( " You used the " + item.getItem() + "-> +" + to_string(item.getValue()) + " health" ));

    } else if(item.getItem() == "key"){
        if(currentRoom->name.compare("bridge") == 0){
            currentRoom->setExits(NULL, NULL, NULL, exit);
            ui->textBrowser->append(QString::fromStdString( " HUZZAH! The path is unlocked\n You can now leave the island" ));

        } else {
            ui->textBrowser->append(QString::fromStdString( "You cannot use that here" ));
        }

    } else if(item.getItem() == "lamp"){
        if(currentRoom->name.compare("caveEntrance") == 0){
            currentRoom->setExits(cave2, NULL, NULL, NULL);
            ui->textBrowser->append(QString::fromStdString(" With the lamp illuminating your way you may now enter the cave" ));

        } else {
            cout << " You cannot use that here" << endl;
        }

    //} else if(item.getItem() == "armour"){


    } else if(item.getItem() == "coins"){
        ui->textBrowser->append(QString::fromStdString( " Coins can be used to buy items" ));
        ui->textBrowser->append(QString::fromStdString( " Try buying an item from a shop" ));
    }
}

int MainWindow::interact(NPC npc){
    if(npc.getName() != "" && npc.getHealth() > 0){
        if(npc.isHostile()){
            ui->textBrowser->append(QString::fromStdString( " You are attacked by: " + npc.getName() + " [" + to_string((npc.getHealth())) + " health]" ));
            ui->textBrowser->append(QString::fromStdString( "                      ->'" + npc.getGreeting() + "'" ));
            ui->textBrowser->append(QString::fromStdString( " -" + to_string(npc.getDamage()) + " health" ));
            ui->textBrowser->append(QString::fromStdString(""));
            return npc.getDamage();
        } else if(npc.getName() == "Dwarf"){
            ui->textBrowser->append(QString::fromStdString( " You meet: " + npc.getName() ));
            ui->textBrowser->append(QString::fromStdString( " Welcome to my store!\n" ));
            ui->textBrowser->append(QString::fromStdString( npc.getStock() ));
            ui->textBrowser->append(QString::fromStdString(""));
        } else {
            ui->textBrowser->append(QString::fromStdString( " You meet: " + npc.getName() ));
            ui->textBrowser->append(QString::fromStdString( "           '" + npc.getGreeting() + "'" ));
            ui->textBrowser->append(QString::fromStdString(""));
        }
    }
    return 0;
}

bool MainWindow::gameOver(bool quit, bool won, int health){
    if(quit){
        ui->textBrowser->append(QString::fromStdString( " You quit the game\n"));
        return false;
    } else if(won){
        ui->textBrowser->append(QString::fromStdString( " You won\n"));
        return false;
    } else if(health <=0){
        ui->textBrowser->append(QString::fromStdString( " You died\n"));
        return false;
    }
    return true;
}

void MainWindow::on_pushButton_north_clicked()
{
    Command command = input.getCommand("go", "north");
    commandAction(command);
    setUpRoom();

    //input.getCommand("go north");
}

void MainWindow::on_pushButton_west_clicked()
{
    Command command = input.getCommand("go", "west");
    commandAction(command);
    setUpRoom();
}

void MainWindow::on_pushButton_south_clicked()
{
    Command command = input.getCommand("go", "south");
    commandAction(command);
    setUpRoom();
}

void MainWindow::on_pushButton_east_clicked()
{
    Command command = input.getCommand("go", "east");
    commandAction(command);
    setUpRoom();
}

void MainWindow::on_pushButton_map_clicked()
{
    Command command = input.getCommand("map");
    commandAction(command);
    setUpRoom();
}

void MainWindow::on_pushButton_search_clicked()
{
    Command command = input.getCommand("search");
    commandAction(command);
    setUpRoom();
}

void MainWindow::on_pushButton_examine_clicked()
{
    string userText = ui->lineEdit->text().toLocal8Bit().constData();
        try {
            if(userText.compare("") == 0){
                throw userText;
            }
        Command command = input.getCommand("examine", userText);
        commandAction(command);
        ui->lineEdit->setText("");
        setUpRoom();
        } catch(string ex){
              ui->textBrowser->append("You must enter the item name you wish to examine into the field above the buttons and then press examine");
        }
}

void MainWindow::on_pushButton_buy_clicked()
{
    string userText = ui->lineEdit->text().toLocal8Bit().constData();
        try {
            if(userText.compare("") == 0){
                throw userText;
            }
        Command command = input.getCommand("buy", userText);
        commandAction(command);
        setUpRoom();
        ui->lineEdit->setText("");
        } catch(string ex){
              ui->textBrowser->append("You must enter the item name you wish to buy into the field above the buttons and then press buy");
        }
}

void MainWindow::on_pushButton_use_clicked()
{
    string userText = ui->lineEdit->text().toLocal8Bit().constData();
        try {
            if(userText.compare("") == 0){
                throw userText;
            }
        Command command = input.getCommand("use", userText);
        commandAction(command);
        setUpRoom();
        ui->lineEdit->setText("");
        } catch(string ex){
              ui->textBrowser->append("You must enter the item name you wish to use into the field above the buttonss and then press use");
        }
}

void MainWindow::on_pushButton_take_clicked()
{
    try{
             string userText = ui->lineEdit->text().toLocal8Bit().constData();
            if(userText.compare("") == 0){
                throw userText;
            }
            Command command = input.getCommand("take", userText);
            commandAction(command);
            setUpRoom();
            ui->lineEdit->setText("");
        }
        catch(string ex){
              ui->textBrowser->append("You must enter the item you wish to take into the field above the buttons and then press take");
        }
}

void MainWindow::on_pushButton_drop_clicked()
{
    string userText = ui->lineEdit->text().toLocal8Bit().constData();
    if(userText.compare("") == 0 && currentRoom->name.compare("mountain3") == 0 && easterEgg){
        easterEgg = false;
        ui->textBrowser->append(QString::fromStdString("\n You trigger an odd event, these words appear before you:\n"));
        LuckyLedge x;
        ui->textBrowser->append(QString::fromStdString(x.tradeItem()));
        if(x.winner()) {
            ui->textBrowser->append(QString::fromStdString("\nYOU HAVE WON!!! CONGRATULATIONS YOU HAVE GAINED SOME COINS"));
            user.addCoins(Item("coins", "A small collection of coins", x.getCount() * 20, 1, false, false));

        } else {
            ui->textBrowser->append(QString::fromStdString("\nUnforetunately you have not won any prize"));
        }

    } else {
        try {
            if(userText.compare("") == 0){
                 throw userText;
            }
            Command command = input.getCommand("drop", userText);
            commandAction(command);
            setUpRoom();
            ui->lineEdit->setText("");
           }
        catch(string ex) {
           ui->textBrowser->append("You must enter text into the field above the buttons");
        }
    }
}

void MainWindow::on_pushButton_inventory_clicked()
{
    ui->textBrowser->append(QString::fromStdString( " Inventory:    " + user.items() ));
}


void MainWindow::on_pushButton_quit_clicked()
{
    quit = true;
    setUpRoom();
}
