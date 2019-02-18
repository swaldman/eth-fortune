pragma solidity ^0.4.24;

contract Fortune {
  string[] public fortunes; // automatically generates an indexed getter (only)

  constructor( string initialFortune ) public {
    addFortune( initialFortune );
  }

  function addFortune( string fortune ) public {
    fortunes.push( fortune );

    emit FortuneAdded( msg.sender, fortune );
  }

  function drawFortune() public view returns ( string fortune ) {
    fortune = fortunes[ shittyRandom() % fortunes.length ];
  }

  function countFortunes() public view returns ( uint count ) {
    count = fortunes.length;	   
  }

  function shittyRandom() private view returns ( uint number ) {
    number = uint( blockhash( block.number - 1 ) );  	   
  }

  event FortuneAdded( address author, string fortune );	
}

