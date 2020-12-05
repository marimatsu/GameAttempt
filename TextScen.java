/**
 *  Text Scenario for the Text Maze game.
 */
public class TextScen extends GraphicsAttempt
{
    public static void foodChange() 
    {
        int choose = (int) (Math.random() * 3);

        switch (choose) 
        {
            case 0: 
            {
                food1();
                break;
            }
            case 1: {
                food2();
                break;
            }
            case 2: {
                food3();
                break;
            }
        }
    }

    public static void food1()
    {
        GraphicsAttempt.print("The day was long and weary. Admittedly, you had considered giving up on this journey due to the struggles alone.");
        GraphicsAttempt.print("However, it's not all bad. On some occassions, you've witnessed new sights, met new people.");
        GraphicsAttempt.print("And now, standing at the edge of the trail, you spy a shrub of berries and a fresh stream.");
        GraphicsAttempt.print("Things are going to be okay, you think to yourself before settling your pack to try your hand at fishing.");

        String Fop1 = "Craft a fishing pole";
            String Fop1Err = "It took too long for you to craft one and the chill of the night came with a discouraging breeze.";
            String Fop1Cor = "Amazing! You fashioned a string fishing pole with a branch lying around and some twine you had.";
        String Fop2 = "Craft a spear to fish";
            String Fop2Err = "You don't know what you were expecting. But somehow wittling down a branch for a makshift spear proved to be far more difficult than expected.";
            String Fop2Cor = "Impeccable! Now in your hands was a weighty spear, capable of hooking a bait to dangle in the stream.";
        String Sop1 = "Dig for a worm bait";
            String Sop1Err = "Were worms this hard to find? You guess they must be since you couldn't find any and the sun had long set in the horizon.";
            String Sop1Cor = "Huzzah! A worm for your troubles was found and you wasted no time hooking it.";
        String Sop2 = "No bait! Try for luck";
            String Sop2Err = "As you wait for your catch to swim along, the setting sun painted the stream in a gold hue. It's pretty... but unfortunately too late.";
            String Sop2Cor = "Wow! Even without a bait, you still managed to score your dinner for the night!";

        String goodEnd = "Success! With the cozy light of your campfire, you munch on your dinner of fish and berries. Stomach now full, you pack away the remaining fish and settle to sleep.";
        String badEnd = "You get a fire going for the night, but as you nibble on the berries your stomach growls. Looks like you'll have to crack open a can tonight...";

        String result = GameStructure.textMaze(Fop1, Fop1Err, Fop1Cor, Fop2, Fop2Err, Fop2Cor, Sop1, Sop1Err, Sop1Cor, Sop2, Sop2Err, Sop2Cor, goodEnd, badEnd);
        player.setFood(result);
    }

    public static void food2()
    {
        GraphicsAttempt.print("You've heard of bandit stories during your travel but thankfully you've been safe for a while.");
        GraphicsAttempt.print("But it seems as if all good things must come to an end for as you awoke in your humble little tent,");
        GraphicsAttempt.print("you heard rustling in the night.");

        String Fop1 = "Look outside";
            String Fop1Err = "It's not as if you're adept at confrontations, but poking your head out had startled the nearest bandit. With a quick swing at your head, you're knocked unconscious.";
            String Fop1Cor = "The bandits outside don't notice as you quietly unzip the flap and you found three bandits rummaging around your camp.";
        String Fop2 = "Pretend to be asleep";
            String Fop2Err = "Was this a smart move? Probably not for after a few silent minutes, the noises had quieted. When you peek out, you've been cleaned out with no traces left to follow. Great.";
            String Fop2Cor = "Silently, you wait. When the noise had died down, grabbed the nearest frying pan and crept out of your tent. You see them in the distance, leaving with your stuff.";
        String Sop1 = "Confront them";
            String Sop1Err = "You yell a war cry while running with your pan high in the air. Unfortunately, yelling allerted them and with a 3v1 fight, it was obvious who was going to lose.";
            String Sop1Cor = "You yell a war cry while running with your pan high in the air. The ferocity in your voice startles them and when you bring down your pan, you're able to take one down. The rest drop everything they had before retreating with their hurt friend.";
        String Sop2 = "Converse with them";
            String Sop2Err = "Well, conflicts could be resolved with words. But that doesn't mean it would be. So with a smirk and a laugh, the bandits flee with your supplies.";
            String Sop2Cor = "Amazing! Somehow, with your words you're able to charm them to tears as they realize the error of their ways. Dropping your stuff and other supplies they had on them, they swore to never steal again.";

        String goodEnd = "That whole event could not have gone any better. Smiling in victory, you grab all of the dropped goods before retreating back in your tent.";
        String badEnd = "Glum and defeated, you heaved a heavy sigh the next day. You suppose it's a good time as any to start looking for more supplies.";

        String result = GameStructure.textMaze(Fop1, Fop1Err, Fop1Cor, Fop2, Fop2Err, Fop2Cor, Sop1, Sop1Err, Sop1Cor, Sop2, Sop2Err, Sop2Cor, goodEnd, badEnd);
        player.setFood(result);

    }

    public static void food3()
    {
        GraphicsAttempt.print("People's kindness are nothing to laugh about. You had just stumbled into a nearby town hoping to buy something.");
        GraphicsAttempt.print("However, when you enter the general store, a farmer asks for your help. They promise to gift you a basket of vegetables and the likes if you assist them in harvesting.");
        GraphicsAttempt.print("Finding this to be benificial, you follow them to their garden. Once there, they tell you, whatever you help harvest can be taken back with you.");

        String Fop1 = "Pick the eggplant";
            String Fop1Err = "Poking the eggplant, you feel your finger bounce against its purple skin. Is this ready to harvest? You don't know but you pick it anyways. Turns out it's not.";
            String Fop1Cor = "The eggplant is firm in your hand. This is definitely ripe, and you gather a bunch in your arms. The farmer is most pleased when he directs you to their orchard.";
        String Fop2 = "Pick the cabbages";
            String Fop2Err = "Holding the cabbage in your hand, the vegetable feels small in your hand. It does look very green though so you pick it. However, the farmer frowns, saying it still needed to grow.";
            String Fop2Cor = "Wow! These are very crisp cabbages! They're heavy and a beautiful green. When you present them to the farmer he smiles in approval before showing you to their orchard.";
        String Sop1 = "Pick apples";
            String Sop1Err = "The apples are kind of falling from their branch. You take this as a sign that they're perfectly ripe. Unfortunately, they're too ripe and the farmer sighs.";
            String Sop1Cor = "You don't think you've ever seen apples redder than these. The farmer is exceptionally happy with this harvest.";
        String Sop2 = "Pick oranges";
            String Sop2Err = "The orange feels soft in your hand... hmm you're no orange expert so you decide to pick it. Apparently, soft oranges mean that it's too ripe...";
            String Sop2Cor = "These orange are very orange! Absolutely impeccable. And the farmer agrees.";

        String goodEnd = "The farmer thanks you for your help. You say no problem. With a bright smile on your face, you leave them with a bounty of food.";
        String badEnd = "You suck at choosing vegetables... and the farmer gives you a pitying look. When they send you on your way, you glance at your handful of junk with a frown. Time to open some canned food, you suppose.";

        String result = GameStructure.textMaze(Fop1, Fop1Err, Fop1Cor, Fop2, Fop2Err, Fop2Cor, Sop1, Sop1Err, Sop1Cor, Sop2, Sop2Err, Sop2Cor, goodEnd, badEnd);
        player.setFood(result);
    }

    public static void healthChange()
    {
        int choose = (int) (Math.random() * 3);

        switch (choose) 
        {
            case 0: 
            {
                health1();
                break;
            }
            case 1:
            {
                health2();
                break;
            }
            case 2:
            {
                health3();
                break;
            }
        }
    }

    public static void health1()
    {
        GraphicsAttempt.print("It's dumb. This situation was dumb, but you had to somehow traverse this powerful river to keep going.");
        GraphicsAttempt.print("Normally, there would be something to ferry people across, but today there's no one or anything around.");
        GraphicsAttempt.print("You debate waiting, but time waits for no one. Thus, you heave a sigh and glance at your pack and the environment.");

        String Fop1 = "Cut down a big tree to walk over";
            String Fop1Err = "You have your ax, and you get to hacking. But your swings weren't strong today, and by the time a ferry arrives, your hands are blistered, body sore, and the tree far from cut.";
            String Fop1Cor = "Danggggg! With a mighty swing, you fell the tree. It falls, across the stream, and you marvel at your makeshift bridge.";
        String Fop2 = "Throw a rope and hope it can lasso to the other side";
            String Fop2Err = "The rope hooks! But it hooks at a piece of driftwood and before long the current has pulled you into the stream. You hit your head on a rock the way down before washing up on the other shore.";
            String Fop2Cor = "The rope hooks! Firmly wrapped around the branch of a thick tree on the other end, you marvel at your handiwork before patting yourself on the back.";
        String Sop1 = "Try to cross by balancing";
            String Sop1Err = "You're not really apt at that. The moment you step on, your legs shake from the fierce current of the river and you're knocked off. You hit your head on a rock the way down before washing up on the other shore.";
            String Sop1Cor = "Were you in the circus previously? Well either way, you traipse across with ease- hopping off your bridge with a flourish.";
        String Sop2 = "Try to cross by hugging your makeshift bridge";
            String Sop2Err = "Slow and bombarded by the rapids of the river, you end up loosing your grip and fall off. You hit your head on a rock the way down before washing up on the other shore.";
            String Sop2Cor = "Go go go! You find yourself swiftly crossing your bridge without a hitch, and before long you're at the other side, feet landing elegantly on the ground.";

        String goodEnd = "Your ingenuity knows no bounds! You've done magnificently well traversing the fierce river, and for that a cheeer! Hip, Hip, Hooray!";
        String badEnd = "Dude... One can't judge much since trying to cross a river is no easy task, but Ouch... You really got hurt trying.";

        String result = GameStructure.textMaze(Fop1, Fop1Err, Fop1Cor, Fop2, Fop2Err, Fop2Cor, Sop1, Sop1Err, Sop1Cor, Sop2, Sop2Err, Sop2Cor, goodEnd, badEnd);
        player.setHP(result);
    }

    public static void health2()
    {
        GraphicsAttempt.print("It's not uncommon to find animals during your journey. Some have ended up as food. Others are mere companions.");
        GraphicsAttempt.print("But dear god, you did not expect to find a poisonous rattlesnake in the middle of your trek!");
        GraphicsAttempt.print("Quick! As it raises its head and rattle its tail, what do you do!");

        String Fop1 = "Stay still";
            String Fop1Err = "You stay still in the face of danger??? Real smart thinking there, pal. The snake doesn't hesitate to strike.";
            String Fop1Cor = "Interesting. You stay so still that you just blend into the environment. The snake doesn't even remember why they felt hostile.";
        String Fop2 = "Mimic the movements of the snake";
            String Fop2Err = "The snake gets offensive by your attempt to mimic it and it goes to strike your ankles.";
            String Fop2Cor = "Your movements are hypnotizing and at some point the snake starts to mimic YOUR movements so now it's weird cause suddenly, who is mimicking who? But distraction: success!";
        String Sop1 = "Run away!";
            String Sop1Err = "The snake snaps to attention at your sudden burst of movement and despite quick, you weren't quick enough and it strikes.";
            String Sop1Cor = "Wow! You're really fast! You don't have to look back to see that you've left the venemous snake in your dust.";
        String Sop2 = "Whack away!";
            String Sop2Err = "You stealthily grab your trusty frying pan and move to whack the snake. But it senses your intention and strikes!";
            String Sop2Cor = "You stealthily grab your trusty frying pan and move to whack the snake. It doesn't notice and before it can even think, you knock it unconscious. Way to go!";

        String goodEnd = "Somehow, you get out of that without so much as a scratch. Seriously, well done, Traveler!";
        String badEnd = "The snake had slithered out of sight after attacking but yikes that really hurt. You're quick to apply an antidote for the poison but the sting on your ankle makes it difficult to walk. ";

        String result = GameStructure.textMaze(Fop1, Fop1Err, Fop1Cor, Fop2, Fop2Err, Fop2Cor, Sop1, Sop1Err, Sop1Cor, Sop2, Sop2Err, Sop2Cor, goodEnd, badEnd);
        player.setHP(result);
    }

    public static void health3()
    {
        GraphicsAttempt.print("You've heard of bandit stories during your travel but thankfully you've been safe for a while.");
        GraphicsAttempt.print("But it seems as if all good things must come to end, for in the middle of your travel you were ambushed by two bandits!");

        String Fop1 = "Play dead";
            String Fop1Err = "They're amazed. They haven't seen this level of stupidity in a long while. They quickly beat you up as result.";
            String Fop1Cor = "Huh... well bandits are dangerous but not smart, so they're rather confused and just stand there looking at you.";
        String Fop2 = "Unleash a war cry";
            String Fop2Err = "They laugh so hard tears run down their face. But alas, they get down to business and attack you without another thought.";
            String Fop2Cor = "This spooks them to the core! Frightened by your guttural scream, they stand there scared out of their wits.";
        String Sop1 = "Smack them with your frying pan!";
            String Sop1Err = "Well, there's hardly any difference between the two choices but sadly, the game decides this wasn't it and you're beaten blue. Sorry, chief.";
            String Sop1Cor = "Bro that was wicked! With a majestic swing of your pan, they're knocked flat on the road!";
        String Sop2 = "Smach them with your own hand!";
            String Sop2Err = "Well, there's hardly any difference between the two choices but sadly, the game decides this wasn't it and you're beaten blue. Sorry, chief.";
            String Sop2Cor = "Bro that was wicked! Your hand must be made out of steel because they're knocked out cold!";

        String goodEnd = "Amazing, just a fantastic show. Who knew you could fight so well.";
        String badEnd = "When you come to, a nasty bruise was on your body... Maybe you should brush up on your fighting skills.";

        String result = GameStructure.textMaze(Fop1, Fop1Err, Fop1Cor, Fop2, Fop2Err, Fop2Cor, Sop1, Sop1Err, Sop1Cor, Sop2, Sop2Err, Sop2Cor, goodEnd, badEnd);
        player.setHP(result);
    }

    public static void waterChange()
    {
        GraphicsAttempt.print("Growing up, you were told never to mess with things you didn't fully comprehend.");
        GraphicsAttempt.print("Thus, staring at this odd contraption of a watering station, you were perplexed. You had never seen something like this before.");
        GraphicsAttempt.print("But you were really parched. So with a deep breath, you decided to mess with the machinery for a chance to drink.");

        String Fop1 = "Pull the lever";
            String Fop1Err = "Amazing. When you pull it, the contraption kind of puffs out a wheeze before whirring to life. It then tells you YOU SUCK before shutting off.";
            String Fop1Cor = "It whirs to life, gears starting to shift in the background and when nothing else happens, you take it as a sign to continue.";
        String Fop2 = "Twist the knob";
            String Fop2Err = "Twisting the knob did something... but you don't think it's the correct something as the machine kind of laughs at you before shutting off.";
            String Fop2Cor = "It whirs to life, gears started to shift in the background. Okay, okay. So far so good.";
        String Sop1 = "Push a button";
            String Sop1Err = "Suddenly things turn for the worse. It's bad! Really bad! The machine starts clanking and hammering and it burst into fire!";
            String Sop1Cor = "Oh would you look at that, water started pouring from a faucet. You take an experimental sip and found to your delight that it's clean! Huzzah!";
        String Sop2 = "Flip a switch";
            String Sop2Err = "Suddenly things are looking terrible! Flipping that switch turned on its self-destruct mode and it's starting to count down until it explodes!";
            String Sop2Cor = "Hey! Water starts pooling in from an untraceable source! You should be worried but it's fresh water so you celebrate instead.";

        String goodEnd = "The water replenishes you greatly and you're invigorated! Hopefully, you see more of this kind further down your journey.";
        String badEnd = "WHY WOULD ANYONE BUILD SOMETHING LIKE THAT IN THE MIDDLE OF THE ROAD?! CURSE YOU WATER MACHINE!";

        String result = GameStructure.textMaze(Fop1, Fop1Err, Fop1Cor, Fop2, Fop2Err, Fop2Cor, Sop1, Sop1Err, Sop1Cor, Sop2, Sop2Err, Sop2Cor, goodEnd, badEnd);
        player.setWater(result);
    }

    public static void rando1()
    {
        GraphicsAttempt.print("This was just the dumbest of all moments for you. Somehow, while you were drinking from your flask, you managed to trip.");
        GraphicsAttempt.print("Of course, this had meant that you plummet face first into the dirt. But you also spill your water.");
        GraphicsAttempt.print("Congrats, you bruised your nose and lost some much needed water.");
        player.setHP("lose");
        player.setWater("lose");
    }

    public static void rando2()
    {
        GraphicsAttempt.print("Hmm, you're not quite sure how it had happened. But when you settled in your camp for the night,");
        GraphicsAttempt.print("a can of some beans and toast heating over the fire, you looked away for what you swore to be a second.");
        GraphicsAttempt.print("Yet when you turn back, your meal for the night had disappeared. It had to be an animal, you think, and you");
        GraphicsAttempt.print("glare at the raccoon that's seemingly laughing at you.");
        player.setFood("lose");
    }

    public static void rando3()
    {
        GraphicsAttempt.print("During your trek, you came across a couple of kids heading back to town!");
        GraphicsAttempt.print("They were running and one of them inevitable bumped into you. They fall, burst into tears, and you calm them down.");
        GraphicsAttempt.print("You then take the opportunity to say they should be more careful. To which they say they would before running away.");
        GraphicsAttempt.print("You hadn't realize that you've been pick pocketed until you make camp and some of your food and water were no longer accounted for.");
        player.setFood("lose");
        player.setWater("lose");
    }

    public static void rando4()
    {
        GraphicsAttempt.print("In the midst of your journey, you came across a stranded family. The wheel of their cart was lodged in a ditch.");
        GraphicsAttempt.print("One of the parents asked for your help to lift the car out of the pothole and you agreed out of the kindness of your heart.");
        GraphicsAttempt.print("With your combined strength, the wheel is dislodged. The family is most thankful and they gift you with food. Score!");
        player.setFood("gain");
    }

    public static void rando5()
    {
        GraphicsAttempt.print("Being on the road for so long, the walks have grown more diffiuclt than easier.");
        GraphicsAttempt.print("Your muscles are sore, your feet blistered, and your mind at times foggy.");
        GraphicsAttempt.print("Thus, when you walk straight in a thorn bush, slip in a deep ditch, and forget a pack of your supplies at the last camp,");
        GraphicsAttempt.print("you just sigh at your misfortune. Perhaps this trip was more ambitious than you thought.");
        player.setFood("lose");
        player.setHP("lose");
        player.setWater("lose");
    }

    public static void rando6()
    {
        GraphicsAttempt.print("Alas, was that the sound of a stream nearby? Inticed to find it, you stray from the path to find a fresh stream!");
        GraphicsAttempt.print("The water was clear, and abundant with fishes. You're hopeful that it's safe to drink, and so you check the water.");
        GraphicsAttempt.print("Luckily for you, it is! Satisfied, you fill your flask and set to fishing for your dinner tonight.");
        player.setFood("gain");
        player.setWater("gain");
    }

    public static void rando7()
    {
        GraphicsAttempt.print("You check your map one day and your jaw slackens. Perhaps you were just too energetic or something, but you did a two day trek in one!");
        GraphicsAttempt.print("Considering how you're above the schedule, you gift yourself a free day and allow yourself to rest early.");
        GraphicsAttempt.print("Hence, you get more sleep and when you wake the next morning, you feel extremely energized!");
        player.setHP("gain");
    }

    public static void rando8()
    {
        GraphicsAttempt.print("At the nearby town, you found yourself involved in a really intense game of poker.");
        GraphicsAttempt.print("You felt extremely confident in the hand that you owned and had bet your food supplies for that dapper monocle your opponent owned.");
        GraphicsAttempt.print("You really like monocles. So after splaying your hand, you're giddy for your new bounty! But unfortunately they bested your hand.");
        GraphicsAttempt.print("You leave the town shamefully without a shiny new monocle. Oh and your food but who cares about that compared to that monocle...");
        player.setFood("lose");
    }

    public static void rando9()
    {
        GraphicsAttempt.print("You stumble something like an oasis at the side of the road. Checking the water, you think it's fine so you refill a flask and take sip.");
        GraphicsAttempt.print("However, an hour into your journey later- your stomach starts to hurt and you end up hurling rainbows over the side.");
        GraphicsAttempt.print("Turns out that water was soiled with something bad, and you solemnly emptied that flask while cluthching at your abdomen.");
        player.setHP("lose");
        player.setWater("lose");
    }
}
