package com.example.wordledang1

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import com.github.jinatonic.confetti.CommonConfetti

val word = GameActivity.FourLetterWordList.getRandomFourLetterWord()
var check1bool = false
var check2bool = false
var check3bool = false
var won = false

class GameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        val returnHome = findViewById<Button>(R.id.buttonGameReturn)

        var et11 = findViewById<EditText>(R.id.et11Game)
        var et12 = findViewById<EditText>(R.id.et12Game)
        var et13 = findViewById<EditText>(R.id.et13Game)
        var et14 = findViewById<EditText>(R.id.et14Game)

        var et21 = findViewById<EditText>(R.id.et21Game)
        var et22 = findViewById<EditText>(R.id.et22Game)
        var et23 = findViewById<EditText>(R.id.et23Game)
        var et24 = findViewById<EditText>(R.id.et24Game)

        var et31 = findViewById<EditText>(R.id.et31Game)
        var et32 = findViewById<EditText>(R.id.et32Game)
        var et33 = findViewById<EditText>(R.id.et33Game)
        var et34 = findViewById<EditText>(R.id.et34Game)

        val point211 = findViewById<ImageView>(R.id.imgArrow11Game)
        val point2enter = findViewById<ImageView>(R.id.imgArrowCheck1Game)
        var gameDesc = findViewById<TextView>(R.id.tvDescGame)

        val check1 = findViewById<TextView>(R.id.buttonCheck1Game)
        val check2 = findViewById<TextView>(R.id.buttonCheck2Game)
        val check3 = findViewById<TextView>(R.id.buttonCheck3Game)



        //val word = FourLetterWordList.getRandomFourLetterWord()
        val l1 = word[0]
        val l2 = word[1]
        val l3 = word[2]
        val l4 = word[3]

        check1.isEnabled=false
        check2.isEnabled=false
        check3.isEnabled=false

        point2enter.isVisible=false

        returnHome.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        if (!check1bool){
            et21.isEnabled=false
            et22.isEnabled=false
            et23.isEnabled=false
            et24.isEnabled=false

            et31.isEnabled=false
            et32.isEnabled=false
            et33.isEnabled=false
            et34.isEnabled=false

            et11.addTextChangedListener(object: TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

                override fun afterTextChanged(s: Editable?) {
                    if (!isEmpty(et11) && !isEmpty(et12) && !isEmpty(et13) && !isEmpty(et14)){
                        check1.setBackgroundColor(Color.parseColor("#1226ff"))
                        check1.isEnabled=true
                        point211.isVisible=false
                        gameDesc.text="press enter"
                        point2enter.isVisible=true
                    }
                    else{
                        check1.setBackgroundColor(Color.parseColor("#626ffc"))
                        check1.isEnabled=false
                        point211.isVisible=true
                        gameDesc.text= "enter a letter"
                        point2enter.isVisible=false

                    }
                }
            })
            et12.addTextChangedListener(object: TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

                override fun afterTextChanged(s: Editable?) {
                    if (!isEmpty(et11) && !isEmpty(et12) && !isEmpty(et13) && !isEmpty(et14)){
                        check1.setBackgroundColor(Color.parseColor("#1226ff"))
                        check1.isEnabled=true
                        point211.isVisible=false
                        gameDesc.text="press enter"
                        point2enter.isVisible=true
                    }
                    else{
                        check1.setBackgroundColor(Color.parseColor("#626ffc"))
                        check1.isEnabled=false
                        point211.isVisible=true
                        gameDesc.text="enter a letter"
                        point2enter.isVisible=false

                    }
                }
            })
            et13.addTextChangedListener(object: TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

                override fun afterTextChanged(s: Editable?) {
                    if (!isEmpty(et11) && !isEmpty(et12) && !isEmpty(et13) && !isEmpty(et14)){
                        check1.setBackgroundColor(Color.parseColor("#1226ff"))
                        check1.isEnabled=true
                        point211.isVisible=false
                        gameDesc.text="press enter"
                        point2enter.isVisible=true
                    }
                    else{
                        check1.setBackgroundColor(Color.parseColor("#626ffc"))
                        check1.isEnabled=false
                        point211.isVisible=true
                        gameDesc.text="enter a letter"
                        point2enter.isVisible=false

                    }
                }
            })
            et14.addTextChangedListener(object: TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

                override fun afterTextChanged(s: Editable?) {
                    if (!isEmpty(et11) && !isEmpty(et12) && !isEmpty(et13) && !isEmpty(et14)){
                        check1.setBackgroundColor(Color.parseColor("#1226ff"))
                        check1.isEnabled=true
                        point211.isVisible=false
                        gameDesc.text="press enter"
                        point2enter.isVisible=true
                    }
                    else{
                        check1.setBackgroundColor(Color.parseColor("#626ffc"))
                        check1.isEnabled=false
                        point211.isVisible=true
                        gameDesc.text="enter a letter here"
                        point2enter.isVisible=false

                    }
                }
            })
        }

        check1.setOnClickListener {
            et11.isEnabled=false
            et12.isEnabled=false
            et13.isEnabled=false
            et14.isEnabled=false

            check(et11,l1)
            check(et12,l2)
            check(et13,l3)
            check(et14,l4)

            check1.isEnabled=false
            check1.setBackgroundColor(Color.parseColor("#626ffc"))
            check1bool=true

            checkWin(et11,et12,et13,et14,gameDesc)

            if (!won){
                et21.isEnabled=true
                et22.isEnabled=true
                et23.isEnabled=true
                et24.isEnabled=true

                gameDesc.text="row 2"
                point211.isVisible=false
                point2enter.isVisible=false



                et21.addTextChangedListener(object: TextWatcher {
                    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
                    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

                    override fun afterTextChanged(s: Editable?) {
                        if (!isEmpty(et21) && !isEmpty(et22) && !isEmpty(et23) && !isEmpty(et24)){
                            check2.setBackgroundColor(Color.parseColor("#1226ff"))
                            check2.isEnabled=true

                        }
                        else{
                            check2.setBackgroundColor(Color.parseColor("#626ffc"))
                            check2.isEnabled=false

                        }
                    }
                })
                et22.addTextChangedListener(object: TextWatcher {
                    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
                    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

                    override fun afterTextChanged(s: Editable?) {
                        if (!isEmpty(et21) && !isEmpty(et22) && !isEmpty(et23) && !isEmpty(et24)){
                            check2.setBackgroundColor(Color.parseColor("#1226ff"))
                            check2.isEnabled=true
                        }
                        else{
                            check2.setBackgroundColor(Color.parseColor("#626ffc"))
                            check2.isEnabled=false

                        }
                    }
                })
                et23.addTextChangedListener(object: TextWatcher {
                    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
                    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

                    override fun afterTextChanged(s: Editable?) {
                        if (!isEmpty(et21) && !isEmpty(et22) && !isEmpty(et23) && !isEmpty(et24)){
                            check2.setBackgroundColor(Color.parseColor("#1226ff"))
                            check2.isEnabled=true
                        }
                        else{
                            check2.setBackgroundColor(Color.parseColor("#626ffc"))
                            check2.isEnabled=false

                        }
                    }
                })
                et24.addTextChangedListener(object: TextWatcher {
                    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
                    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

                    override fun afterTextChanged(s: Editable?) {
                        if (!isEmpty(et21) && !isEmpty(et22) && !isEmpty(et23) && !isEmpty(et24)){
                            check2.setBackgroundColor(Color.parseColor("#1226ff"))
                            check2.isEnabled=true
                        }
                        else{
                            check2.setBackgroundColor(Color.parseColor("#626ffc"))
                            check2.isEnabled=false

                        }
                    }
                })
            }

        }

        check2.setOnClickListener {
            et21.isEnabled=false
            et22.isEnabled=false
            et23.isEnabled=false
            et24.isEnabled=false

            check(et21,l1)
            check(et22,l2)
            check(et23,l3)
            check(et24,l4)

            check2.isEnabled=false
            check2.setBackgroundColor(Color.parseColor("#626ffc"))
            check2bool=true

            checkWin(et21,et22,et23,et24,gameDesc)

            if (!won){
                et31.isEnabled=true
                et32.isEnabled=true
                et33.isEnabled=true
                et34.isEnabled=true

                gameDesc.text="row 3"



                et31.addTextChangedListener(object: TextWatcher {
                    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
                    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

                    override fun afterTextChanged(s: Editable?) {
                        if (!isEmpty(et31) && !isEmpty(et32) && !isEmpty(et33) && !isEmpty(et34)){
                            check3.setBackgroundColor(Color.parseColor("#1226ff"))
                            check3.isEnabled=true
                        }
                        else{
                            check3.setBackgroundColor(Color.parseColor("#626ffc"))
                            check3.isEnabled=false

                        }
                    }
                })
                et32.addTextChangedListener(object: TextWatcher {
                    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
                    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

                    override fun afterTextChanged(s: Editable?) {
                        if (!isEmpty(et31) && !isEmpty(et32) && !isEmpty(et33) && !isEmpty(et34)){
                            check3.setBackgroundColor(Color.parseColor("#1226ff"))
                            check3.isEnabled=true
                        }
                        else{
                            check3.setBackgroundColor(Color.parseColor("#626ffc"))
                            check3.isEnabled=false

                        }
                    }
                })
                et33.addTextChangedListener(object: TextWatcher {
                    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
                    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

                    override fun afterTextChanged(s: Editable?) {
                        if (!isEmpty(et31) && !isEmpty(et32) && !isEmpty(et33) && !isEmpty(et34)){
                            check3.setBackgroundColor(Color.parseColor("#1226ff"))
                            check3.isEnabled=true
                        }
                        else{
                            check3.setBackgroundColor(Color.parseColor("#626ffc"))
                            check3.isEnabled=false

                        }
                    }
                })
                et34.addTextChangedListener(object: TextWatcher {
                    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
                    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

                    override fun afterTextChanged(s: Editable?) {
                        if (!isEmpty(et31) && !isEmpty(et32) && !isEmpty(et33) && !isEmpty(et34)){
                            check3.setBackgroundColor(Color.parseColor("#1226ff"))
                            check3.isEnabled=true
                        }
                        else{
                            check3.setBackgroundColor(Color.parseColor("#626ffc"))
                            check3.isEnabled=false

                        }
                    }
                })
            }

        }

        check3.setOnClickListener {
            et31.isEnabled=false
            et32.isEnabled=false
            et33.isEnabled=false
            et34.isEnabled=false

            check(et31,l1)
            check(et32,l2)
            check(et33,l3)
            check(et34,l4)

            check3.isEnabled=false
            check3.setBackgroundColor(Color.parseColor("#626ffc"))
            check3bool=true

            checkWin(et31,et32,et33,et34,gameDesc)
        }



    }

    private fun isEmpty(etText: EditText): Boolean {
        return etText.text.toString().trim { it <= ' ' }.isEmpty()
    }

    private fun check(etText: EditText, letter: Char){
        if (etText.text.toString()==letter.toString()){
            etText.setBackgroundColor(Color.parseColor("#6CA965"))
        }
        else if (etText.text.toString() in word){
            etText.setBackgroundColor(Color.parseColor("#c8b653"))
        }
    }

    private fun checkWin(et1: EditText, et2: EditText, et3: EditText, et4: EditText, desc: TextView){
        if ((et1.text.toString()+et2.text.toString()+et3.text.toString()+et4.text.toString())==word){
            desc.setText("you winnn")
            desc.setTextColor(Color.parseColor("#6CA965"))
            won=true
        }
        else if (check1bool && check2bool && check3bool){
            desc.setText(word)
            desc.setTextColor(Color.parseColor("#a34b4b"))
        }
    }

    object FourLetterWordList {
        // List of most common 4 letter words from: https://7esl.com/4-letter-words/
        val fourLetterWords =
            "Area,Army,Baby,Back,Ball,Band,Bank,Base,Bill,Body,Book,Call,Card,Care,Case,Cash,City,Club,Cost,Date,Deal,Door,Duty,East,Edge,Face,Fact,Farm,Fear,File,Film,Fire,Firm,Fish,Food,Foot,Form,Fund,Game,Girl,Goal,Gold,Hair,Half,Hall,Hand,Head,Help,Hill,Home,Hope,Hour,Idea,Jack,John,Kind,King,Lack,Lady,Land,Life,Line,List,Look,Lord,Loss,Love,Mark,Mary,Mind,Miss,Move,Name,Need,News,Note,Page,Pain,Pair,Park,Part,Past,Path,Paul,Plan,Play,Post,Race,Rain,Rate,Rest,Rise,Risk,Road,Rock,Role,Room,Rule,Sale,Seat,Shop,Show,Side,Sign,Site,Size,Skin,Sort,Star,Step,Task,Team,Term,Test,Text,Time,Tour,Town,Tree,Turn,Type,Unit,User,View,Wall,Week,West,Wife,Will,Wind,Wine,Wood,Word,Work,Year,Bear,Beat,Blow,Burn,Call,Care,Cast,Come,Cook,Cope,Cost,Dare,Deal,Deny,Draw,Drop,Earn,Face,Fail,Fall,Fear,Feel,Fill,Find,Form,Gain,Give,Grow,Hang,Hate,Have,Head,Hear,Help,Hide,Hold,Hope,Hurt,Join,Jump,Keep,Kill,Know,Land,Last,Lead,Lend,Lift,Like,Link,Live,Look,Lose,Love,Make,Mark,Meet,Mind,Miss,Move,Must,Name,Need,Note,Open,Pass,Pick,Plan,Play,Pray,Pull,Push,Read,Rely,Rest,Ride,Ring,Rise,Risk,Roll,Rule,Save,Seek,Seem,Sell,Send,Shed,Show,Shut,Sign,Sing,Slip,Sort,Stay,Step,Stop,Suit,Take,Talk,Tell,Tend,Test,Turn,Vary,View,Vote,Wait,Wake,Walk,Want,Warn,Wash,Wear,Will,Wish,Work,Able,Back,Bare,Bass,Blue,Bold,Busy,Calm,Cold,Cool,Damp,Dark,Dead,Deaf,Dear,Deep,Dual,Dull,Dumb,Easy,Evil,Fair,Fast,Fine,Firm,Flat,Fond,Foul,Free,Full,Glad,Good,Grey,Grim,Half,Hard,Head,High,Holy,Huge,Just,Keen,Kind,Last,Late,Lazy,Like,Live,Lone,Long,Loud,Main,Male,Mass,Mean,Mere,Mild,Nazi,Near,Neat,Next,Nice,Okay,Only,Open,Oral,Pale,Past,Pink,Poor,Pure,Rare,Real,Rear,Rich,Rude,Safe,Same,Sick,Slim,Slow,Soft,Sole,Sore,Sure,Tall,Then,Thin,Tidy,Tiny,Tory,Ugly,Vain,Vast,Very,Vice,Warm,Wary,Weak,Wide,Wild,Wise,Zero,Ably,Afar,Anew,Away,Back,Dead,Deep,Down,Duly,Easy,Else,Even,Ever,Fair,Fast,Flat,Full,Good,Half,Hard,Here,High,Home,Idly,Just,Late,Like,Live,Long,Loud,Much,Near,Nice,Okay,Once,Only,Over,Part,Past,Real,Slow,Solo,Soon,Sure,That,Then,This,Thus,Very,When,Wide"

        // Returns a list of four letter words as a list
        fun getAllFourLetterWords(): List<String> {
            return fourLetterWords.split(",")
        }

        // Returns a random four letter word from the list in all caps
        fun getRandomFourLetterWord(): String {
            val allWords = getAllFourLetterWords()
            val randomNumber = (0..allWords.size).shuffled().last()
            return allWords[randomNumber].uppercase()
        }
    }
}