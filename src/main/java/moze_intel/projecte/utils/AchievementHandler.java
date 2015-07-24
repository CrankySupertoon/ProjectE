package moze_intel.projecte.utils;

import com.google.common.collect.ImmutableList;
import moze_intel.projecte.gameObjs.ObjHandler;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;


public final class AchievementHandler
{

	public final static Achievement PHIL_STONE = (Achievement) new Achievement("phil_stone", "phil_stone", 0, 2, ObjHandler.philosStone, null).initIndependentStat().registerStat();
	public final static Achievement ALCH_CHEST = (Achievement) new Achievement("alch_chest", "alch_chest", 0, -2, ObjHandler.alchChest, null).initIndependentStat().registerStat();
	public final static Achievement ALCH_BAG = (Achievement) new Achievement("alch_bag", "alch_bag", 0, -4, ObjHandler.alchBag, ALCH_CHEST).registerStat();
	public final static Achievement TRANSMUTATION = (Achievement) new Achievement("transmutation", "transmutation", 0, 0, ObjHandler.transmuteStone, PHIL_STONE).registerStat();
	public final static Achievement CONDENSER = (Achievement) new Achievement("condenser", "condenser", -2, -2, ObjHandler.condenser, ALCH_CHEST).setSpecial().registerStat();
	public final static Achievement COLLECTOR = (Achievement) new Achievement("collector", "collector", -2, -4, ObjHandler.energyCollector, CONDENSER).setSpecial().registerStat();
	public final static Achievement RELAY = (Achievement) new Achievement("relay", "relay", -4, -4, ObjHandler.relay, COLLECTOR).setSpecial().registerStat();
	public final static Achievement PORTABLE_TRANSMUTATION = (Achievement) new Achievement("portable_transmutation", "portable_transmutation", -2, 0, ObjHandler.transmutationTablet, TRANSMUTATION).setSpecial().registerStat();
	public final static Achievement DARK_MATTER = (Achievement) new Achievement("dark_matter", "dark_matter", 2, 0, new ItemStack(ObjHandler.matter, 1, 0), null).initIndependentStat().registerStat();
	public final static Achievement RED_MATTER = (Achievement) new Achievement("red_matter", "red_matter", 2, -2, new ItemStack(ObjHandler.matter, 1, 1), DARK_MATTER).setSpecial().registerStat();
	public final static Achievement DM_BLOCK = (Achievement) new Achievement("dm_block", "dm_block", 4, 0, new ItemStack(ObjHandler.matterBlock, 1, 0), DARK_MATTER).setSpecial().registerStat();
	public final static Achievement RM_BLOCK = (Achievement) new Achievement("rm_block", "rm_block", 4, -2, new ItemStack(ObjHandler.matterBlock, 1, 1), RED_MATTER).setSpecial().registerStat();
	public final static Achievement DM_FURNACE = (Achievement) new Achievement("dm_furnace", "dm_furnace", 6, 0, ObjHandler.dmFurnaceOff, DM_BLOCK).setSpecial().registerStat();
	public final static Achievement RM_FURNACE = (Achievement) new Achievement("rm_furnace", "rm_furnace", 6, -2, ObjHandler.rmFurnaceOff, RM_BLOCK).setSpecial().registerStat();
	public final static Achievement DM_PICK = (Achievement) new Achievement("dm_pick", "dm_pick", 2, 2, ObjHandler.dmPick, DARK_MATTER).registerStat();
	public final static Achievement RM_PICK = (Achievement) new Achievement("rm_pick", "rm_pick", 2, 4, ObjHandler.rmPick, DM_PICK).setSpecial().registerStat();
	public final static Achievement KLEIN_BASIC = (Achievement) new Achievement("klein", "klein", 0, 4, new ItemStack(ObjHandler.kleinStars, 1, 0), PHIL_STONE).registerStat();
	public final static Achievement KLEIN_MASTER = (Achievement) new Achievement("klein_big", "klein_big", -2, 4, new ItemStack(ObjHandler.kleinStars, 1, 5), KLEIN_BASIC).setSpecial().registerStat();

	public static ImmutableList<Achievement> list = ImmutableList.of(
			PHIL_STONE, ALCH_CHEST, ALCH_BAG, TRANSMUTATION, CONDENSER,
			COLLECTOR, RELAY, PORTABLE_TRANSMUTATION, DARK_MATTER, RED_MATTER, DM_BLOCK,
			RM_BLOCK, DM_FURNACE, RM_FURNACE, DM_PICK, RM_PICK, KLEIN_BASIC, KLEIN_MASTER
	);

	public static void init()
	{
		AchievementPage.registerAchievementPage(new AchievementPage("ProjectE", list.toArray(new Achievement[list.size()])));
	}
}
