// Course: ____Artificial Intelligence section 2__________
// Student name: ____ernesto perez__________
// Student ID: ____000978131__________
// Assignment #: _____1_________
// Due Date: __2/5/2024____________
// Signature: ___ep___________ (Your signature assures that everything is your own work
// Score: ______________ (Note: Score will be posted on D2L)
//        II. Design of your Agent: Tic-Tac-Toe player
//        III. Tasks that your agent will solve: Win or draw at Tic-Tac-Toe


import java.util.Arrays;
import java.util.Random;


public class AIassignment {


    public static char[][] playingField= {{'-','-','-'},{'-','-','-'},{'-','-','-'}};
    public int option=0;
    public int moves=0;
    public boolean moved=false;
    public void showPlayingField(char[][] mat){ // shows tic-tac-toe

        for (char[] row : mat)

            System.out.println( Arrays.toString(row) );

        System.out.println();
    }
    public boolean openSpot(int a, int b){ //if that spot was empty or not
        if(playingField[a][b]=='x'||playingField[a][b]=='o'){
            return false;
        }
        else
            return true;
    }
    public boolean outOfSpace(){ //just says if their are no more spaces to play
        boolean out=true;
        for(int i=0;i<playingField.length;i++){
            for(int j=0;j<playingField.length;j++){
                if(playingField[i][j]=='-'){
                    return false;
                }
            }

        }
        return true;
    }
    public void dontLetThemWin(){


        for(int i=0;i<playingField.length;i++) { //stops them if they are about win a row

            for (int j = 0; j < playingField.length; j++) {
                if(playingField[i][0]=='o'&&playingField[i][1]=='o'){
                    playingField[i][2]='x';
                    moved=true;
                }
                else if(playingField[i][1]=='o'&&playingField[i][2]=='o'){
                    playingField[i][0]='x';
                    moved=true;
                }

            }
        }


        if(playingField[0][0]=='o'&&playingField[1][1]=='o'){ //stops a win diagonally
           playingField[2][2]='x';
            moved=true;
        }
        else if(playingField[1][1]=='o'&&playingField[2][2]=='o'){ //stops a win diagonally
            playingField[0][0]='x';
            moved=true;
        }
        else if(playingField[2][0]=='o'&&playingField[1][1]=='o'){ //stops a win diagonally
           playingField[0][2]='x';
            moved=true;
        }
        else if(playingField[1][1]=='o'&&playingField[0][2]=='o'){ //stops a win diagonally
          playingField[2][0]='x';
            moved=true;
        }


        for(int i=0;i<playingField.length;i++){ //checks if any player won vertically

            for(int j=0;j<playingField.length;j++){

                if(playingField[0][j]=='o'&&playingField[1][j]=='o'){
                    playingField[2][j]='x';
                    moved=true;
                }
                else if(playingField[2][j]=='o'&&playingField[1][j]=='o'){
                    playingField[0][j]='x';
                    moved=true;
                }
            }
        }



    }

    public void letThemWin(){ //lets us choose path to victory


        for(int i=0;i<playingField.length;i++) { //stops them if they are about win a row

            for (int j = 0; j < playingField.length; j++) {
                if(playingField[i][0]=='x'&&playingField[i][1]=='x'){
                    playingField[i][2]='x';
                    moved=true;
                }
                else if(playingField[i][1]=='x'&&playingField[i][2]=='x'){
                    playingField[i][0]='x';
                    moved=true;
                }

            }
        }


        if(playingField[0][0]=='x'&&playingField[1][1]=='x'){ //stops a win diagonally
            playingField[2][2]='x';
            moved=true;
        }
        else if(playingField[1][1]=='x'&&playingField[2][2]=='x'){ //stops a win diagonally
            playingField[0][0]='x';
            moved=true;
        }
        else if(playingField[2][0]=='x'&&playingField[1][1]=='x'){ //stops a win diagonally
            playingField[0][2]='x';
            moved=true;
        }
        else if(playingField[1][1]=='x'&&playingField[0][2]=='x'){ //stops a win diagonally
            playingField[2][0]='x';
            moved=true;
        }


        for(int i=0;i<playingField.length;i++){ //checks if any player won vertically

            for(int j=0;j<playingField.length;j++){

                if(playingField[0][j]=='x'&&playingField[1][j]=='x'){
                    playingField[2][j]='x';
                    moved=true;
                }
                else if(playingField[2][j]=='x'&&playingField[1][j]=='x'){
                    playingField[0][j]='x';
                    moved=true;
                }
            }
        }



    }

    public void endGame(){ //game ends in draw
        dontLetThemWin();



    }

    public boolean winner(){


        for(int i=0;i<playingField.length;i++){ //checks if any player won horizontally
            int wonX=0;
            int wonO=0;
            for(int j=0;j<playingField.length;j++){

                if(playingField[i][j]=='x'){
                    ++wonX;
                    if(wonX==3){
                        System.out.println("CONGRATS x");
                        return true;
                    }
                }
                if(playingField[i][j]=='o'){
                    ++wonO;
                    if(wonO==3){
                        System.out.println("CONGRATS o");
                        return true;
                    }
                }

            }
        }

        if(playingField[0][0]=='x'&&playingField[1][1]=='x'&&playingField[2][2]=='x'){ //check diagonally
            System.out.println("x wins!");
            return true;
        }
        if(playingField[0][0]=='o'&&playingField[1][1]=='o'&&playingField[2][2]=='o'){ //check diagonally
            System.out.println("o wins!");
            return true;
        }
        if(playingField[2][0]=='x'&&playingField[1][1]=='x'&&playingField[0][2]=='x'){ //check diagonally
            System.out.println("x wins!");
            return true;
        }
        if(playingField[2][0]=='o'&&playingField[1][1]=='o'&&playingField[0][2]=='o'){ //check diagonally
            System.out.println("x wins!");
            return true;
        }


        for(int i=0;i<playingField.length;i++){ //checks if any player won vertically
            int wonX=0;
            int wonO=0;
            for(int j=0;j<playingField.length;j++){

                if(playingField[j][i]=='x'){
                    ++wonX;
                    if(wonX==3){
                        return true;
                    }
                }
                if(playingField[j][i]=='o'){
                    ++wonO;
                    if(wonO==3){
                        return true;
                    }
                }
            }
        }


        return false;
    }
    //code for playing x(first turn)

    public void firstPlay(){    //did you know in Tic-Tac-Toe it is impossible to win if you go second and the first player
                                //  doesn't make a mistake afterwards
        moves+=2;
        playingField[2][0]='x';
        showPlayingField(playingField);
        Random rand= new Random(); // opponents move
        int a1=rand.nextInt(2);
        int a2=rand.nextInt(2);
        if(!openSpot(a1,a2)) { //checks for open spot to randomly put marker
            while (!openSpot(a1, a2)) {
                a1 = rand.nextInt(2);
                a2 = rand.nextInt(2);


            }
            playingField[a1][a2] = 'o';
        }
        else{
            playingField[a1][a2] = 'o';
        }
        winner();
        showPlayingField(playingField);


    }


    public void nextPlay(){
        moves+=2;
        if(playingField[0][0]=='o'||playingField[0][1]=='o'||playingField[1][0]=='o'){ //o is at the top left
            playingField[2][2]='x';
            option=1;
        }
        else if(playingField[2][2]=='o'||playingField[2][1]=='o'||playingField[1][2]=='o'){ //o is at the bottom right
            playingField[0][0]='x';
            option=2;
        }
        else if(playingField[0][2]=='o'){ // o is across from x
            playingField[0][0]='x';
            option=3;
        }
        else if(playingField[1][1]=='o'){
            option=4;

            Random rand= new Random();
            int a1=rand.nextInt(3);
            int a2=rand.nextInt(3);

            if(!openSpot(a1,a2)) {
                while (!openSpot(a1, a2)) { ////checks for open spot to randomly put marker

                    showPlayingField(playingField);
                    a1 = rand.nextInt(3);
                    a2 = rand.nextInt(3);


                }
                playingField[a1][a2] = 'x';
            }
            else{
                playingField[a1][a2]='x';
            }
        }
        showPlayingField(playingField);
        Random rand= new Random(); // opponents move
        int a1=rand.nextInt(3);
        int a2=rand.nextInt(3);
        if(!openSpot(a1,a2)) { //checks for open spot to randomly put marker
            while (!openSpot(a1, a2)) {

                a1 = rand.nextInt(3);
                a2 = rand.nextInt(3);


            }
            playingField[a1][a2] = 'o';
        }
        else{
            playingField[a1][a2] = 'o';
        }
        winner();
        showPlayingField(playingField);


    }
    public void nextNextPlay(){
        showPlayingField(playingField);
        moves+=2;

        if(option==1){
            if(openSpot(2,1)){
                playingField[2][1]='x';

                if(winner()){return;}
            }
            else {
                playingField[1][1]='x';
                if(winner()){return;}
                option=5;
            }
        }
        else if(option==2){
            if(openSpot(1,0)){
                playingField[1][0]='x';
                if(winner()){return;}
            }
            else {
                playingField[1][1]='x';
                if(winner()){return;}
                option=5;
            }
        }
        else if(option==3){
            if (openSpot(0,1)){
                playingField[0][1]='x';
                if(winner()){return;}
            }
            else{
                playingField[2][2]='x';
                if(winner()){return;}
                option=5;
            }
        }
        else if(option==4){

            dontLetThemWin();
            while(!outOfSpace()||!winner()) {
                moved = false;
                letThemWin();
                if (!moved) { //if no move was made in letThemWin or dontLetThemWin choose random spot
                    Random rand = new Random();
                    int a1 = rand.nextInt(3);
                    int a2 = rand.nextInt(3);

                    if (!openSpot(a1, a2)) {
                        while (!openSpot(a1, a2)) { ////checks for open spot to randomly put marker

                            showPlayingField(playingField);
                            a1 = rand.nextInt(3);
                            a2 = rand.nextInt(3);


                        }
                        playingField[a1][a2] = 'x';
                    } else {
                        playingField[a1][a2] = 'x';
                    }
                }
                if (winner()) {
                    return;
                }
                showPlayingField(playingField);
            }

        }
        else if(playingField[0][2]=='0'){
            Random rand= new Random();
            int a1=rand.nextInt(3);
            int a2=rand.nextInt(3);

            if(!openSpot(a1,a2)) {
                while (!openSpot(a1, a2)) { ////checks for open spot to randomly put marker

                    showPlayingField(playingField);
                    a1 = rand.nextInt(3);
                    a2 = rand.nextInt(3);


                }
                playingField[a1][a2] = 'x';
            }
            else{
                playingField[a1][a2]='x';
            }
        }
        showPlayingField(playingField);
        Random rand= new Random(); // opponents move
        int a1=rand.nextInt(2);
        int a2=rand.nextInt(2);
        if(!openSpot(a1,a2)) {
            while (!openSpot(a1, a2)) {
                a1 = rand.nextInt(2);
                a2 = rand.nextInt(2);


            }
            playingField[a1][a2] = 'o';
        }
        else{
            playingField[a1][a2] = 'o';
        }
        if(winner()){return;}

        showPlayingField(playingField);
    }
    public void nextNextNextMove(){
        moves+=2;
        if(option ==3){
            if(openSpot(1,1)){
                playingField[1][1]='x';
                if(winner()){return;}
            }
            else{
                playingField[2][1]='x';
                if(winner()){return;}
            }
        }
        else if(option==5){
            letThemWin();
            if(winner()){return;}
            while(!outOfSpace()||!winner()) {
                letThemWin();
                if(winner()){return;}
                showPlayingField(playingField);
                Random rand= new Random(); // opponents move
                int a1=rand.nextInt(2);
                int a2=rand.nextInt(2);
                if(!openSpot(a1,a2)) {
                    while (!openSpot(a1, a2)) {
                        a1 = rand.nextInt(2);
                        a2 = rand.nextInt(2);


                    }
                    playingField[a1][a2] = 'o';
                }
                else{
                    playingField[a1][a2] = 'o';
                }
                if(winner()){return;}
                showPlayingField(playingField);
            }
            return;
        }
        else{
            while(!outOfSpace()||!winner()) {
                moved=false;
                letThemWin();
                if(!moved){ //if no move was made in letThemWin or dontLetThemWin choose random spot
                    Random rand= new Random();
                    int a1=rand.nextInt(3);
                    int a2=rand.nextInt(3);

                    if(!openSpot(a1,a2)) {
                        while (!openSpot(a1, a2)) { ////checks for open spot to randomly put marker

                            showPlayingField(playingField);
                            a1 = rand.nextInt(3);
                            a2 = rand.nextInt(3);


                        }
                        playingField[a1][a2] = 'x';
                    }
                    else{
                        playingField[a1][a2]='x';
                    }
                }
                if(winner()){return;}
                showPlayingField(playingField);
                Random rand= new Random(); // opponents move
                int a1=rand.nextInt(2);
                int a2=rand.nextInt(2);
                if(!openSpot(a1,a2)) {
                    while (!openSpot(a1, a2)) {
                        a1 = rand.nextInt(2);
                        a2 = rand.nextInt(2);


                    }
                    playingField[a1][a2] = 'o';
                }
                else{
                    playingField[a1][a2] = 'o';
                }
                if(winner()){return;}
                showPlayingField(playingField);
            }
            return;
        }
        showPlayingField(playingField);
        Random rand= new Random(); // opponents move
        int a1=rand.nextInt(2);
        int a2=rand.nextInt(2);
        if(!openSpot(a1,a2)) {
            while (!openSpot(a1, a2)) {
                a1 = rand.nextInt(2);
                a2 = rand.nextInt(2);


            }
            playingField[a1][a2] = 'o';
        }
        else{
            playingField[a1][a2] = 'o';
        }
        if(winner()){return;}
        showPlayingField(playingField);





    }

    // end of code for first turn
public static void main(String[] args){

 AIassignment a= new AIassignment();
 a.showPlayingField(playingField);
 int w=0;
 do {
     a.firstPlay();
     if(a.winner())
     {
         a.showPlayingField(playingField);
         break;}
     a.nextPlay();
     if(a.winner()) {
         a.showPlayingField(playingField);
         break;
     }
     a.nextNextPlay();
     if(a.winner()|| a.outOfSpace()) {
         a.showPlayingField(playingField);
         break;
     }

     a.nextNextNextMove();
     if(a.winner()|| a.outOfSpace()) {
         a.showPlayingField(playingField);
         break;
     }

     if(a.outOfSpace()){ //in case of a draw
         System.out.println("DRAW!!!!");
     }
     w++;

 }
 while(w==1);
}
}
