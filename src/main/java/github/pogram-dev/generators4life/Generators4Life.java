package me.CHANGEME.slimefunaddon;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.libraries.dough.config.Config;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;

public class ExampleAddon extends JavaPlugin implements SlimefunAddon {

    @Override
    public void onEnable() {
    	
    	NamespacedKey categoryId = new NamespacedKey(this, "great_gens");
    	CustomItemStack categoryItem = new CustomItemStack(Material.BEDROCK, "&4Brought to you by Ban Ban!");
    	ItemGroup itemGroup = new ItemGroup(categoryId, categoryItem);
    	
    	SlimefunItemStack itemStack = new SlimefunItemStack("GRAND_PLACEHOLDER", Material.EMERALD, "&aMaster Emerald", "", "&7How did you get this? Are you some sort of... WIZARD?!");
    	
    	RecipeType.ENHANCED_CRAFTING_TABLE
    	ItemStack[] recipe = {
    			new ItemStack(Material.EMERALD), new ItemStack(Material.LODESTONE), new ItemStack(Material.EMERALD),
    			new ItemStack(Material.ENDER_PEARL), new ItemStack(Material.ELYTRA), new ItemStack(Material.ENDER_PEARL),
    			new ItemStack(Material.EMERALD), new ItemStack(Material.EMERALD_BLOCK), new ItemStack(Material.EMERALD)
    	}
    	
    	SlimefunItemStack itemStack = new SlimefunItmeStack("DECEIT_CAKE", Material.CAKE, "&aJust a cake!", "&7WARNING: Don't eat this.", "&7The Cake Is A Lie.");
    	
    	ItemStack[] recipe = {
    			new ItemStack(Material.WHEAT_SEEDS), null, new ItemStack(Material.WHEAT_SEEDS),
    			null, new ItemStack(Material.FLINT_AND_STEEL), null,
    			new ItemStack(Material.WHEAT_SEEDS), null, new ItemStack(Material.WHEAT_SEEDS)
    	};
    	
    	public class FireCake extends SlimefunItem{
    		public FireCake(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, itemStack[] recipe) {
    			super(itemGroup, item, recipeType, recipe);
    		}
    		
    		@Override
    		public void preRegister() {
    			BlockUseHandler blockUseHandler = this::onBlockRightClick;
    			addItemHandler(blockUseHandler);
    		}
    		
    		private void onBlockRightClick(PlayerRightClickEvent event) {
    			event.cancel();
    			event.getPlayer().setFireTicks(5 * 20);
    		}
    	}
        
    	FireCake cake = new FireCake(itemGroup, itemStack, RecipeType.ENHANCED_CRAFTING_TABLE, recipe);
    	cake.register(this);
        // Read something from your config.yml
        Config cfg = new Config(this);

        if (cfg.getBoolean("options.auto-update")) {
            // You could start an Auto-Updater for example
        }

        /*
         * 1. Creating a new Category
         * This Category will use the following ItemStack
         */

        // Give your Category a unique id.
       
        /*
         * 2. Create a new SlimefunItemStack
         * This class has many constructors, it is very important
         * that you give each item a unique id.
         */

        /*
         * 3. Creating a Recipe
         * The Recipe is an ItemStack Array with a length of 9.
         * It represents a Shaped Recipe in a 3x3 crafting grid.
         * The machine in which this recipe is crafted in is specified
         * further down as the RecipeType.
         */

        /*
         * 4. Registering the Item
         * Now you just have to register the item.
         * RecipeType.ENHANCED_CRAFTING_TABLE refers to the machine in
         * which this item is crafted in.
         * Recipe Types from Slimefun itself will automatically add the recipe to that machine.
         */
    }

    @Override
    public void onDisable() {
        // Logic for disabling the plugin...
    }

    @Override
    public String getBugTrackerURL() {
        // You can return a link to your Bug Tracker instead of null here
        return null;
    }

    @Override
    public JavaPlugin getJavaPlugin() {
        /*
         * You will need to return a reference to your Plugin here.
         * If you are using your main class for this, simply return "this".
         */
        return this;
    }

}
