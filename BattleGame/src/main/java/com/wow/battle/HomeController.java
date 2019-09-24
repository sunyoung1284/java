package com.wow.battle;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	boolean whoseTurn = true;
	String battle_proceeding = "";
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		DBCommon<Player> dbCommon = new DBCommon<Player>("c:\\tomcat\\player.sqlite", "player");
		model.addAttribute("select_result", dbCommon.selectDataTableTag(new Player()));
		
		battle_proceeding = "";
		
		return "list";

	}
	
	@RequestMapping(value = "/input", method = RequestMethod.GET)
	public String input(Locale locale, Model model) {
		
		return "input";
	}
	
	@RequestMapping(value = "/input_data", method = RequestMethod.GET)
	public String input_data(Locale locale, Model model, @RequestParam("name") String name,
			@RequestParam("attack") String attack,
			@RequestParam("shield") String shield,
			@RequestParam("att_prob") String att_prob,
			@RequestParam("shld_prob") String shld_prob,
			@RequestParam("hp") String hp) {
		DBCommon<Player> dbCommon = new DBCommon<Player>("c:\\tomcat\\player.sqlite", "player");
		dbCommon.insertData(new Player(name, attack, shield, att_prob, shld_prob, hp));
		
		return "done";
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public String modify(Locale locale, Model model, @RequestParam("idx") int idx) {
		DBCommon<Player> dbCommon = new DBCommon<Player>("c:\\tomcat\\player.sqlite", "player");
		model.addAllAttributes(dbCommon.detailsData(new Player(), idx));
		
		return "modify";
	}
	
	@RequestMapping(value = "/modify_data", method = RequestMethod.GET)
	public String modify_data(Locale locale, Model model, @RequestParam("idx") int idx, 
			@RequestParam("name") String name,
			@RequestParam("attack") String attack,
			@RequestParam("shield") String shield,
			@RequestParam("att_prob") String att_prob,
			@RequestParam("shld_prob") String shld_prob,
			@RequestParam("hp") String hp
			) {
		DBCommon<Player> dbCommon = new DBCommon<Player>("c:\\tomcat\\player.sqlite", "player");
		dbCommon.updateData(new Player(name, attack, shield, att_prob, shld_prob, hp), idx);
		
		return "done";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(Locale locale, Model model,  @RequestParam("idx") int idx) {
		DBCommon<Player> dbCommon = new DBCommon<Player>("c:\\tomcat\\player.sqlite", "player");
		dbCommon.deleteData(new Player(), idx);
		
		return "done";
	}
	
	@RequestMapping(value = "/game_start", method = RequestMethod.GET)
	public String battle(Locale locale, Model model, @RequestParam(value="chk_info", required=false) List<Integer> values){
		
		if (values == null) {
			return "done";
		} else if (values.size() != 2) {
			return "done";
		}
		
		DBCommon<Player> dbCommon = new DBCommon<Player>("c:\\tomcat\\player.sqlite", "player");
		
		int userIdx1 = values.get(0);
		int userIdx2 = values.get(1);
		
		HashMap<String, String> user1 = new HashMap<String, String>();
		HashMap<String, String> user2 = new HashMap<String, String>();
		user1 = dbCommon.detailsData(new Player(), userIdx1);
		user2 = dbCommon.detailsData(new Player(), userIdx2);

		
		model.addAttribute("selected_user_1", dbCommon.selectDataTableTag2(new Player(), userIdx1));
		model.addAttribute("selected_user_2", dbCommon.selectDataTableTag2(new Player(), userIdx2));

		DBCommon<Player> dbCommon2 = new DBCommon<Player>("c:\\tomcat\\player.sqlite", "PvP");
		dbCommon2.insertData2(new Player(Integer.parseInt(user1.get("idx")),user1.get("name"),user1.get("attack"),user1.get("shield"),
				user1.get("att_prob"),user1.get("shld_prob"),user1.get("hp")));
		dbCommon2.insertData2(new Player(Integer.parseInt(user2.get("idx")),user2.get("name"),user2.get("attack"),user2.get("shield"),
				user2.get("att_prob"),user2.get("shld_prob"),user2.get("hp")));
		
		return "battle";
	}
	
	@RequestMapping(value = "/PvP", method = RequestMethod.GET)
	public String PvP(Locale locale, Model model, @RequestParam(value="user", required=true) List<Integer> values) {
		DBCommon<Player> dbCommon = new DBCommon<Player>("c:\\tomcat\\player.sqlite", "PvP");
		
		int userIdx1 = values.get(0);
		int userIdx2 = values.get(1);
		
		model.addAttribute("selected_user_1", dbCommon.selectDataTableTag2(new Player(), userIdx1));
		model.addAttribute("selected_user_2", dbCommon.selectDataTableTag2(new Player(), userIdx2));
		
		HashMap<String, String> firstUser = new HashMap<String, String>();
		HashMap<String, String> secondUser = new HashMap<String, String>();
		firstUser = dbCommon.detailsData(new Player(), userIdx1);
		secondUser = dbCommon.detailsData(new Player(), userIdx2);
		
		String firstUserName = firstUser.get("name");
		int firstUserAttackPower = Integer.parseInt(firstUser.get("attack"));
		int firstUserShieldPower = Integer.parseInt(firstUser.get("shield"));
		int firstUserAtt_Prob = Integer.parseInt(firstUser.get("att_prob"));
		int firstUserShld_Prob = Integer.parseInt(firstUser.get("shld_prob"));
		int firstUserHP = Integer.parseInt(firstUser.get("hp"));
		
		String SecondUserName = secondUser.get("name");
		int SecondUserAttackPower = Integer.parseInt(secondUser.get("attack"));
		int SecondUserShieldPower = Integer.parseInt(secondUser.get("shield"));
		int SecondUserAtt_Prob = Integer.parseInt(secondUser.get("att_prob"));
		int SecondUserShld_Prob = Integer.parseInt(secondUser.get("shld_prob"));
		int SecondUserHP = Integer.parseInt(secondUser.get("hp"));
		
		Random random = new Random();
		int attProbStandard = random.nextInt(100) + 1;
		int shldProbStandard = random.nextInt(100) + 1;
		
		if (whoseTurn) {
			if (firstUserAtt_Prob >= attProbStandard) {
				if (SecondUserShld_Prob >= shldProbStandard) {
					//방어성공 공격력에서 방어력 만큼 빼서 공격력을 만듬.
					int attackPower = firstUserAttackPower - SecondUserShieldPower;
					SecondUserHP = SecondUserHP - attackPower;
					battle_proceeding += firstUserName + "공격 성공! " + SecondUserName + "이(가) " + attackPower + "의 데미지를 입었습니다. <br/>";
				} else {
					//방어실패
					SecondUserHP = SecondUserHP - firstUserAttackPower;
					battle_proceeding += firstUserName + "공격 대성공! " + SecondUserName + "이(가) " + firstUserAttackPower + "의 데미지를 입었습니다. <br/>";
				}
			} else {
				SecondUserHP = SecondUserHP;
				battle_proceeding += firstUserName + "공격 실패! <br/>";
			}
			whoseTurn = false;
			
			if (SecondUserHP < 0) {
				return "done";
			}
			
		}else {
			if (SecondUserAtt_Prob >= attProbStandard) {
				if (firstUserShld_Prob >= shldProbStandard) {
					//방어성공 공격력에서 방어력 만큼 빼서 공격력을 만듬.
					int attackPower = SecondUserAttackPower - firstUserShieldPower;
					firstUserHP = firstUserHP - attackPower;
					battle_proceeding += SecondUserName + "공격 성공! " + firstUserName + "이(가) " + attackPower + "의 데미지를 입었습니다. <br/>";
				} else {
					//방어실패
					firstUserHP = firstUserHP - SecondUserAttackPower;
					battle_proceeding += SecondUserName + "공격 대성공! " + firstUserName + "이(가) " + SecondUserAttackPower + "의 데미지를 입었습니다. <br/>";
				}
			} else {
				firstUserHP = firstUserHP;
				battle_proceeding += SecondUserName + "공격 실패! <br/>";
			}
			whoseTurn = true;
			
			if (firstUserHP < 0) {
				return "done";
			}
		}
		
		model.addAttribute("battle_proceeding", battle_proceeding);
		
		dbCommon.updateData(new Player(firstUserName,  Integer.toString(firstUserAttackPower), 
				 Integer.toString(firstUserShieldPower), 
				 Integer.toString(firstUserAtt_Prob), 
				 Integer.toString(firstUserShld_Prob), 
				 Integer.toString(firstUserHP)), userIdx1);
		
		dbCommon.updateData(new Player(SecondUserName,  Integer.toString(SecondUserAttackPower), 
				 Integer.toString(SecondUserShieldPower), 
				 Integer.toString(SecondUserAtt_Prob), 
				 Integer.toString(SecondUserShld_Prob), 
				 Integer.toString(SecondUserHP)), userIdx2);
		
		return "battle";

	}
	
//	@RequestMapping(value = "/done", method = RequestMethod.GET)
//	public String done(Locale locale, Model model, @RequestParam("idx") int idx, 
//			@RequestParam("name") String name, 
//			@RequestParam("attack") String attack, 
//			@RequestParam("shield") String shield,
//			@RequestParam("att_prob") String att_prob,
//			@RequestParam("shld_prob") String shld_prob,
//			@RequestParam("hp") String hp,
//			@RequestParam("game") int game,
//			@RequestParam("win") int win,
//			@RequestParam("lose") int lose,
//			@RequestParam("result") boolean result) {
//		DBCommon<Player> dbCommon = new DBCommon<Player>("c:\\tomcat\\player.sqlite", "player");
//		
////		String name, String attack, String shield, String att_prob, String shld_prob, String hp, String game, String win, String lose
//		
//		dbCommon.updateResultData(new Player(name, attack, shield, att_prob, shld_prob, hp, game, win, lose), idx, result);
//		
//		return "done";
//	}
	
	@RequestMapping(value = "/create_table", method = RequestMethod.GET)
	public String createTable(Locale locale, Model model) {
		DBCommon<Player> dbCommon = new DBCommon<Player>("c:\\tomcat\\player.sqlite", "player");
		dbCommon.createTable(new Player());
		return "done";
	}
	
	@RequestMapping(value = "/create_table2", method = RequestMethod.GET)
	public String createTable2(Locale locale, Model model) {
		DBCommon<Player> dbCommon = new DBCommon<Player>("c:\\tomcat\\player.sqlite", "PvP");
		dbCommon.createTable2(new Player());
		return "done";
	}
	
}
