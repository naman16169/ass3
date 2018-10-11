package com.example.bunny.ass3;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;


public class DetailActivity extends AppCompatActivity {
    DatabaseHelp mDatabaseHelper;
    public static int no=0;
    private int serverResponseCode=0;

    public static  String[] Questions= {"Whaling attack is kind of phishing attacks that target senior executives and other high profile to access information.",
            "Freeware is software that is available for use at no monetary cost.",
            "IPv6 Internet Protocol address is represented as eight groups of four Octal digits.",
            "The hexadecimal number system contains digits from 1 - 15.",
            "Octal number system contains digits from 0 - 7.",
            "MS Word is a hardware.",
            "CPU controls only input data of computer.",
            "CPU stands for Central Performance Unit.",
            "The Language that the computer can understand is called Machine Language.",
            "Magnetic Tape used random access method.",
            "Twitter is an online social networking and blogging service.",
            "Worms and trojan horses are easily detected and eliminated by antivirus software.",
            "Dot-matrix, Deskjet, Inkjet and Laser are all types of Printers.",
            "GNU / Linux is a open source operating system.",
            "When you include multiple addresses in a message, you should separate each address with a period (.).",
            "You cannot format text in an e-mail message.",
            "You must include a subject in any mail message you compose.",
            "If you want to respond to the sender of a message, click the Respond button.",
            "You type the body of a reply the same way you would type the body of a new message.",
            "When you reply to a message, you need to enter the text in the Subject: field.",
            "You can only print one copy of a selected message.",
            "You cannot preview a message before you print it.",
            "There is only one way to print a message.",
            "When you print a message, it is automatically deleted from your Inbox.",
            "You need to delete a contact and creat a new one to change contact information.",
            "You must complete all fields in the Contact form before you can save the contact.",
            "You cannot edit Contact forms.",
            "You should always open and attachment before saving it.",
            "All attachment are safe.",
            "It is impossible to send a worm or virus over the Internet using in attachment."
    };




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        final int id;
        id = intent.getIntExtra("id",-1);
        TextView textView=(TextView) findViewById(R.id.textView4);
        textView.setText(Questions[id]);
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        mDatabaseHelper = new DatabaseHelp(this);
        if(no==0) {
            for (int i = 0; i < 30; i++) {
                mDatabaseHelper.addQues(i + 1, Questions[i], "null");
            }
            no+=1;
        }


        final int[] option = new int[1];
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.radioButton) {
                    option[0] =1*gg();
                } else if(checkedId == R.id.radioButton2) {
                    option[0] =2*gg();
                }
            }

        });

        Button Save=(Button) findViewById(R.id.button);
        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(option[0]==1*gg()){
                    mDatabaseHelper.Update(id+1,"True");
                }
                else if(option[0]==2*gg()){
                    mDatabaseHelper.Update(id+1,"False");
                }
            }
        });
    }
    public int gg(){
        return 1;
    }
}
