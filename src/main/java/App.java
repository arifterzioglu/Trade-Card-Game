
import Managers.Interface.IPlayerManager;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import Managers.Interface.IGameManager;;
public class App {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		IGameManager gameManager = context.getBean("gameManager", IGameManager.class );

		IPlayerManager pmg = context.getBean("playerManager", IPlayerManager.class);
		gameManager.initializeGame();
		gameManager.startGame();
	}

}
