# README.txt by Juanlu J. Laredo
# 24.03.2018
# version 1.0
# modified 26.03.2022 by Juanlu J. Laredo

A. CONTENT This zip file must include the following files:

   * README.txt - The file you are reading right now
   * GameServerUDP.jar - jar file containing a version of the Server to play twist-lock 
   * GameClientUDP.jar - jar file containing a version of the Client to play twist-lock 
   * random.properties - a file containing the properties to set up the client as a random player 
   * run.sh - bash script for running locally a game (server + two different players) 
   * server.sh - it launches a server listening in port 8000 and a client with a random AI
   * client.sh - it launches a udp client in the command line
   
B. INSTRUCTIONS TO EXECUTE THE APPLICATION LOCALLY IN YOUR COMPUTER

   1. Unzip the folder and make sure that you got all the files (see A. CONTENT)
   
   2. If you are in a bash terminal simply run: 
         
         $ ./run.sh
         
C. INSTRUCTIONS TO EXECUTE THE DIFFERENT COMPONENTS (SERVER AND CLIENTS)
    
   1. You may want to run the twist-lock server standalone. For that:
      
         $ java -jar GameServerUDP.jar <port>
      
      where <port> refers to the port in which your server will be listening.
      
   2. It is also possible to run a twist-lock client with a random intelligence. For that:
        
         $ java -jar GameClientUDP.jar random.properties
               
      
D. INSTRUCTIONS TO EXECUTE THE APPLICATION IN DIFFERENT MACHINES


   1.  Run the server in a machine:
      
         $ java -jar GameServerUDP.jar <port>

   2.  In a second machine, edit random.properties
       
       2.1. Modify the "ip" value with the ip address of the server
       2.2. Modify the "port" value with the port in which the server is listening
       2.3. Run the client with the modified random.properties:
      
         $ java -jar GameClientUDP.jar random.properties
         
   3. Repeat the step 2 in a third machine to get a second player.
       
