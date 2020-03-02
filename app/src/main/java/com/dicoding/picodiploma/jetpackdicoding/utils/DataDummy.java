package com.dicoding.picodiploma.jetpackdicoding.utils;


import com.dicoding.picodiploma.jetpackdicoding.data.MovieEntity;
import com.dicoding.picodiploma.jetpackdicoding.data.TvEntity;

import java.util.ArrayList;

public class DataDummy {

    public static ArrayList<MovieEntity> generateDummyMovie() {
        ArrayList<MovieEntity> movie = new ArrayList<>();

        movie.add(new MovieEntity(
                "m01",
                "Venom",
                "Investigative journalist Eddie Brock attempts a comeback following a scandal, but accidentally becomes the host of Venom, a violent, super powerful alien symbiote. Soon, he must rely on his newfound powers to protect the world from a shadowy organization looking for a symbiote of their own.",
                "2018-09-28",
                "English",
                "Science Fiction, Action",
                "@drawable/poster_venom",
                "1h 52m"));
        movie.add(new MovieEntity("m02",
                "Bumblebee",
                "On the run in the year 1987, Bumblebee finds refuge in a junkyard in a small Californian beach town. Charlie, on the cusp of turning 18 and trying to find her place in the world, discovers Bumblebee, battle-scarred and broken. When Charlie revives him, she quickly learns this is no ordinary yellow VW bug.",
                "2018-12-15",
                "English",
                "Action, Adventure, Science Fiction",
                "@drawable/poster_bumblebee",
                "1h 54m"));
        movie.add(new MovieEntity("m03",
                "A Star Is Born",
                "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Allys career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.",
                "2018-10-03",
                "English",
                "Drama, Romance, Music",
                "@drawable/poster_a_star",
                "2h 16m"));
        movie.add(new MovieEntity("m04",
                "Spider-man: Into the Spider-Verse",
                "Miles Morales is juggling his life between being a high school student and being a spider-man. When Wilson \"Kingpin\" Fisk uses a super collider, others from across the Spider-Verse are transported to this dimension.",
                "2018-12-06",
                "English",
                "Action, Adventure, Animation, Science Fiction, Comedy",
                "@drawable/poster_spiderman",
                "1h 57m"));
        movie.add(new MovieEntity("m05",
                "Aquaman",
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orms half-human, half-Atlantean brother and true heir to the throne.",
                "2018-12-07",
                "English",
                "Action, Adventure, Fantasy",
                "@drawable/poster_aquaman",
                "2h 24m"));
        movie.add(new MovieEntity("m06",
                "Bohemian Rhapsody",
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock n roll band Queen in 1970. Hit songs become instant classics. When Mercurys increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                "2018-10-24",
                "English",
                "Drama, Music",
                "@drawable/poster_bohemian",
                "2h 15m"));
        movie.add(new MovieEntity("m07",
                "Avenger: Infinity War",
                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
                "2018-04-25",
                "English",
                "Adventure, Action, Science Fiction",
                "@drawable/poster_avengerinfinity",
                "2h 29m"));
        movie.add(new MovieEntity("m08",
                "Bird Box",
                "Five years after an ominous unseen presence drives most of society to suicide, a survivor and her two children make a desperate bid to reach safety.",
                "2018-12-13",
                "English",
                "Thriller, Drama",
                "@drawable/poster_birdbox",
                "2h 4m"));
        movie.add(new MovieEntity("m09",
                "Creed",
                "The former World Heavyweight Champion Rocky Balboa serves as a trainer and mentor to Adonis Johnson, the son of his late friend and former rival Apollo Creed.",
                "2015-11-25",
                "English",
                "Drama",
                "@drawable/poster_creed",
                "2h 13m"));

        movie.add(new MovieEntity("m010",
                "Preman Pensiun",
                "After three years, the business of Muslihat (Epi Kusnandar), who has retired as a thug, has a problem. Sales decline. Muslihat also faces new problems when Safira (Safira Maharani), her only daughter, grows up in adolescence and begins to be visited by boys. A bigger problem: frictions between his former subordinates.",
                "2019-01-17",
                "Indonesian",
                "Comedy, Drama",
                "@drawable/poster_preman",
                "1h 34m"));

        return movie;
    }

    public static ArrayList<TvEntity> generateDummyTv() {
        ArrayList<TvEntity> tv = new ArrayList<>();

        tv.add(new TvEntity("t01",
                "Arrow",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                "2012-10-10",
                "English",
                "Crime, Drama, Mystery, Action & Adventure",
                "@drawable/poster_arrow",
                "42m"));
        tv.add(new TvEntity("t02",
                "Legacies",
                "In a place where young witches, vampires, and werewolves are nurtured to be their best selves in spite of their worst impulses, Klaus Mikaelson’s daughter, 17-year-old Hope Mikaelson, Alaric Saltzman’s twins, Lizzie and Josie Saltzman, among others, come of age into heroes and villains at The Salvatore School for the Young and Gifted.",
                "2018-10-25",
                "Sci-Fi & Fantasy, Drama",
                "English",
                "@drawable/poster_legacies",
                "43m"));
        tv.add(new TvEntity("t03",
                "Prison Break",
                "Due to a political conspiracy, an innocent man is sent to death row and his only hope is his brother, who makes it his mission to deliberately get himself sent to the same prison in order to break the both of them out, from the inside out.",
                "2005-08-29",
                "English",
                "Crime, Action & Adventure, Drama",
                "@drawable/poster_prison_break",
                "45m"));
        tv.add(new TvEntity("t04",
                "Supernatural",
                "When they were boys, Sam and Dean Winchester lost their mother to a mysterious and demonic supernatural force. Subsequently, their father raised them to be soldiers. He taught them about the paranormal evil that lives in the dark corners and on the back roads of America ... and he taught them how to kill it. Now, the Winchester brothers crisscross the country in their '67 Chevy Impala, battling every kind of supernatural threat they encounter along the way.",
                "2005-09-13",
                "English",
                "Drama, Mystery, Sci-Fi & Fantasy",
                "@drawable/poster_supernatural",
                "45m"));
        tv.add(new TvEntity("t05",
                "The Blacklist",
                "Raymond \"Red\" Reddington, one of the FBI's most wanted fugitives, surrenders in person at FBI Headquarters in Washington, D.C. He claims that he and the FBI have the same interests: bringing down dangerous criminals and terrorists. In the last two decades, he's made a list of criminals and terrorists that matter the most but the FBI cannot find because it does not know they exist. Reddington calls this \"The Blacklist\". Reddington will co-operate, but insists that he will speak only to Elizabeth Keen, a rookie FBI profiler.",
                "2013-09-23",
                "English",
                "Drama, Crime, Mystery",
                "@drawable/poster_the_blacklist",
                "43m"));
        tv.add(new TvEntity("t06",
                "The Expanse",
                "A thriller set two hundred years in the future following the case of a missing young woman who brings a hardened detective and a rogue ship's captain together in a race across the solar system to expose the greatest conspiracy in human history.",
                "2015-12-14",
                "English",
                "Drama, Mystery, Sci-Fi & Fantasy",
                "@drawable/poster_the_expanse",
                "43m"));
        tv.add(new TvEntity("t07",
                "The Mandalorian",
                "After the fall of the Galactic Empire, lawlessness has spread throughout the galaxy. A lone gunfighter makes his way through the outer reaches, earning his keep as a bounty hunter.",
                "2019-11-12",
                "English",
                "Sci-Fi & Fantasy, Action & Adventure",
                "@drawable/poster_the_mandalorian",
                "35m"));
        tv.add(new TvEntity("t08",
                "The Simpsons",
                "Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning, the series has been a pop culture icon, attracting hundreds of celebrities to guest star. The show has also made name for itself in its fearless satirical take on politics, media and American life in general.",
                "1989-12-17",
                "English",
                "Animation, Comedy",
                "@drawable/poster_the_simpsons",
                "22m"));
        tv.add(new TvEntity("t09",
                "The Walking Dead",
                "Sheriff's deputy Rick Grimes awakens from a coma to find a post-apocalyptic world dominated by flesh-eating zombies. He sets out to find his family and encounters many other survivors along the way.",
                "2010-10-31",
                "English",
                "Action &  Adventure, Drama, Sci-Fi & Fantasy",
                "@drawable/poster_the_walking_dead",
                "42m, 60m, 45m"));
        tv.add(new TvEntity("t010",
                "Vikings",
                "The adventures of Ragnar Lothbrok, the greatest hero of his age. The series tells the sagas of Ragnar's band of Viking brothers and his family, as he rises to become King of the Viking tribes. As well as being a fearless warrior, Ragnar embodies the Norse traditions of devotion to the gods. Legend has it that he was a direct descendant of Odin, the god of war and warriors.",
                "2013-03-03",
                "English",
                "Action & Adventure, Drama",
                "@drawable/poster_vikings",
                "44m, 60m"));

        return tv;
    }
}
