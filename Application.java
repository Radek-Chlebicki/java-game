package game;
//radek and mesbah

import java.util.Arrays;
import java.util.List;

import edu.monash.fit2099.engine.*;

public class Application {
//	public static Player player = new Player("Player", '@', 1, 9999);

	public static void main(String[] args) {
		BNWorld world = new BNWorld(new Display());

		GameMap earthGameMap;
		GameMap moonGameMap;

		List<String> earthMap = Arrays.asList(
				".......................",
				"....#####....######....",
				"....#...#....#....#....",
				"....D...D....D....#....",
				"....#####....######....",
				".......................",
				".......................",
				"........j......w.......",
				".......................",
				"......................f",
				"......................X");

		List<String> moonMap = Arrays.asList(
				".....................",
				".....................",
				".....................",
				".....................",
				".....................",
				".....................",
				".....................",
				".....................",
				".....................",
				".....................",
				".....................",
				"....................."
		);


		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		//moon map
		FancyGroundFactory moonGroundFactory = new FancyGroundFactory(new FloorGround(), new WallGround(), new DoorGround());
		moonGameMap = new GameMap(moonGroundFactory, moonMap);
		world.addMap(moonGameMap);
		//earth map
		FancyGroundFactory groundFactory = new FancyGroundFactory(new FloorGround(), new WallGround(), new RocketBuildGround(), new JailGround(), new OxygenDispenserGround(), new DoorGround(),  new WaterGround());
		earthGameMap = new GameMap(groundFactory, earthMap);
		world.addMap(earthGameMap);

		StunnablePlayer stunnablePlayer = new StunnablePlayer("Player", '@', 1, 9999, moonGameMap, earthGameMap, world);




		//earth map
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// add the player
		world.addPlayer(stunnablePlayer, earthGameMap, 0, 0);


		// put plans in left room
		QPlansItem aplansItemQ = new QPlansItem();
		earthGameMap.addItem(aplansItemQ, 5,2);

		// in right room
		EnemyDoctorMaybeActor aEnemyDoctorMaybeActor = new EnemyDoctorMaybeActor();
		earthGameMap.addActor(aEnemyDoctorMaybeActor, 14,2);


		// enemies
		// goons
		Actor aGoonActor1 = new EnemyGoonActor("Joshua the Goon", stunnablePlayer);
		earthGameMap.addActor(aGoonActor1, 3, 3);

		Actor aGoonActor2 = new EnemyGoonActor("Nate the Goon", stunnablePlayer);
		earthGameMap.addActor(aGoonActor2, 3, 5);

		// grunts
		EnemyGruntActor enemyGruntActor1 = new EnemyGruntActor("Norbert", stunnablePlayer);
		earthGameMap.addActor(enemyGruntActor1, 11, 3);
		EnemyGruntActor enemyGruntActor2 = new EnemyGruntActor("stal", stunnablePlayer);
		earthGameMap.addActor(enemyGruntActor2, 15, 10);

		// Ninja
		EnemyNinjaActor aEnemyNinjaActor = new EnemyNinjaActor("Joshua the ninja ", stunnablePlayer);
		earthGameMap.addActor(aEnemyNinjaActor,20,0);





		//power ups

		// add the stick
		Item aStick = new StickWeaponItem();
		earthGameMap.addItem(aStick, 0,1);

		QActor aQActor = new QActor();
		earthGameMap.addActor(aQActor,1,5);


		SpaceSuitItem spaceSuitItem = new SpaceSuitItem();
		earthGameMap.addItem(spaceSuitItem,19,9);



		//moon map
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		EnemyYugoMaxActor enemyYugoMaxActor = new EnemyYugoMaxActor();
		moonGameMap.addActor(enemyYugoMaxActor,10,6 );


		// moon map return rocket
		Item returnRocket = Item.newFurniture("The Complete Rocket", DisplayChars.RocketCompleteItemChar);
		returnRocket.getAllowableActions().add(new MoveActorAction(earthGameMap.at(22,10 ), "to earth"));
		moonGameMap.addItem(returnRocket, 1, 1);


		// power ups
		Item thePistol = new WaterPistolItem();
		moonGameMap.addItem(thePistol,7,6);


		// enemies
		// goons
		Actor aMoonGoonActor1 = new EnemyGoonActor("Joshua the Moon Goon", stunnablePlayer);
		moonGameMap.addActor(aMoonGoonActor1, 3, 3);

		Actor aMoonGoonActor2 = new EnemyGoonActor("Nate the Moon Goon", stunnablePlayer);
		moonGameMap.addActor(aMoonGoonActor2, 3, 5);

		// grunts
		EnemyGruntActor enemyMoonGruntActor1 = new EnemyGruntActor("Moon Norbert", stunnablePlayer);
		moonGameMap.addActor(enemyMoonGruntActor1, 11, 3);
		EnemyGruntActor enemyMoonGruntActor2 = new EnemyGruntActor("stalin ", stunnablePlayer);
		moonGameMap.addActor(enemyMoonGruntActor2, 15, 10);

		// Ninja
		EnemyNinjaActor aEnemyMoonNinjaActor = new EnemyNinjaActor("Joshua the Moon ninja ", stunnablePlayer);
		moonGameMap.addActor(aEnemyMoonNinjaActor,20,5);




		world.run();
	}
}
