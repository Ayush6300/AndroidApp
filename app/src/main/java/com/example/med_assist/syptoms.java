package com.example.med_assist;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class syptoms extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private MyPagerAdapter pagerAdapter;

    private Button button ;

    List<String> features = new ArrayList<>();
    String id;
    int size=0, temp =1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_syptoms);

        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.view_pager);
        pagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        button = findViewById(R.id.predict);

        Intent intent = getIntent();
        List<String> receivedValues = intent.getStringArrayListExtra("Parts");

        id = intent.getStringExtra("id");

        if (receivedValues != null) {
            for (String value : receivedValues) {
                // Store the value in your list or perform any other desired operations
                // For example, you can store them in another list:
                features.add(value);
                size = features.size();
                temp = size;

            }
        }
        if(size<11){
            while (size<11){
                features.add("37");
                size=features.size();
            }
        }

        pagerAdapter.notifyDataSetChanged();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(syptoms.this,test.class);
                intent.putExtra("id",id);
                startActivity(intent);

            }
        });

    }

    private class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:

                    if (Objects.equals(features.get(0), "0")) {
                        return new frag_head();
                    } else if (Objects.equals(features.get(0), "1")) {
                        return new frag_abdomen();
                    } else if (Objects.equals(features.get(0), "2")) {
                        return new fag_throat();
                    } else if (Objects.equals(features.get(0), "3")) {
                        return new frag_lb();
                    } else if (Objects.equals(features.get(0), "4")) {
                        return new frag_ear();
                    } else if (Objects.equals(features.get(0), "5")) {
                        return new frag_eyes();
                    } else if (Objects.equals(features.get(0), "6")) {
                        return new frag_mouth();
                    } else if (Objects.equals(features.get(0), "7")) {
                        return new frag_nose();
                    } else if (Objects.equals(features.get(0), "8")) {
                        return new frag_heart();
                    } else if (Objects.equals(features.get(0), "9")) {
                        return new frag_joint(id);

                    } else if (Objects.equals(features.get(0), "10")) {
                        return new frag_chest();
                    } else {
                        return null;
                    }

                case 1:
                    if(Objects.equals(features.get(1), "0")){
                        return new frag_head();
                    } else if (Objects.equals(features.get(1), "1")) {
                        return new frag_abdomen();
                    } else if (Objects.equals(features.get(1), "2")) {
                        return new fag_throat();
                    } else if (Objects.equals(features.get(1), "3")) {
                        return new frag_lb();
                    } else if (Objects.equals(features.get(1), "4")) {
                        return new frag_ear();
                    } else if (Objects.equals(features.get(1), "5")) {
                        return new frag_eyes();
                    } else if (Objects.equals(features.get(1), "6")) {
                        return new frag_mouth();
                    }else if (Objects.equals(features.get(1), "7")){
                        return new frag_nose();
                    } else if (Objects.equals(features.get(1), "8")) {
                        return new frag_heart();
                    } else if (Objects.equals(features.get(1), "9")) {
                        return new frag_joint("njnj");
                    } else if (Objects.equals(features.get(1), "10")) {
                        return new frag_chest();
                    } else {
                        return null;
                    }
                case 2:
                    if(Objects.equals(features.get(2), "0")){
                        return new frag_head();
                    } else if (Objects.equals(features.get(2), "1")) {
                        return new frag_abdomen();
                    } else if (Objects.equals(features.get(2), "2")) {
                        return new fag_throat();
                    } else if (Objects.equals(features.get(2), "3")) {
                        return new frag_lb();
                    } else if (Objects.equals(features.get(2), "4")) {
                        return new frag_ear();
                    } else if (Objects.equals(features.get(2), "5")) {
                        return new frag_eyes();
                    } else if (Objects.equals(features.get(2), "6")) {
                        return new frag_mouth();
                    }else if (Objects.equals(features.get(2), "7")){
                        return new frag_nose();
                    } else if (Objects.equals(features.get(2), "8")) {
                        return new frag_heart();
                    } else if (Objects.equals(features.get(2), "9")) {
                        return new frag_joint("jbb");
                    } else if (Objects.equals(features.get(2), "10")) {
                        return new frag_chest();
                    } else {
                        return null;
                    }
                case 3:
                    if(Objects.equals(features.get(3), "0")){
                        return new frag_head();
                    } else if (Objects.equals(features.get(3), "1")) {
                        return new frag_abdomen();
                    } else if (Objects.equals(features.get(3), "2")) {
                        return new fag_throat();
                    } else if (Objects.equals(features.get(3), "3")) {
                        return new frag_lb();
                    } else if (Objects.equals(features.get(3), "4")) {
                        return new frag_ear();
                    } else if (Objects.equals(features.get(3), "5")) {
                        return new frag_eyes();
                    } else if (Objects.equals(features.get(3), "6")) {
                        return new frag_mouth();
                    }else if (Objects.equals(features.get(3), "7")){
                        return new frag_nose();
                    } else if (Objects.equals(features.get(3), "8")) {
                        return new frag_heart();
                    } else if (Objects.equals(features.get(3), "9")) {
                        return new frag_joint("jbhb");
                    } else if (Objects.equals(features.get(3), "10")) {
                        return new frag_chest();
                    } else {
                        return null;
                    }
                    case 4:
                        if(Objects.equals(features.get(4), "0")){
                            return new frag_head();
                        } else if (Objects.equals(features.get(4), "1")) {
                            return new frag_abdomen();
                        } else if (Objects.equals(features.get(4), "2")) {
                            return new fag_throat();
                        } else if (Objects.equals(features.get(4), "3")) {
                            return new frag_lb();
                        } else if (Objects.equals(features.get(4), "4")) {
                            return new frag_ear();
                        } else if (Objects.equals(features.get(4), "5")) {
                            return new frag_eyes();
                        } else if (Objects.equals(features.get(4), "6")) {
                            return new frag_mouth();
                        }else if (Objects.equals(features.get(4), "7")){
                            return new frag_nose();
                        } else if (Objects.equals(features.get(4), "8")) {
                            return new frag_heart();
                        } else if (Objects.equals(features.get(4), "9")) {
                            return new frag_joint("jbjb");
                        } else if (Objects.equals(features.get(4), "10")) {
                            return new frag_chest();
                        } else {
                            return null;
                        }
                case 5:
                    if(Objects.equals(features.get(5), "0")){
                        return new frag_head();
                    } else if (Objects.equals(features.get(5), "1")) {
                        return new frag_abdomen();
                    } else if (Objects.equals(features.get(5), "2")) {
                        return new fag_throat();
                    } else if (Objects.equals(features.get(5), "3")) {
                        return new frag_lb();
                    } else if (Objects.equals(features.get(5), "4")) {
                        return new frag_ear();
                    } else if (Objects.equals(features.get(5), "5")) {
                        return new frag_eyes();
                    } else if (Objects.equals(features.get(5), "6")) {
                        return new frag_mouth();
                    }else if (Objects.equals(features.get(5), "7")){
                        return new frag_nose();
                    } else if (Objects.equals(features.get(5), "8")) {
                        return new frag_heart();
                    } else if (Objects.equals(features.get(5), "9")) {
                        return new frag_joint("jbjb");
                    } else if (Objects.equals(features.get(5), "10")) {
                        return new frag_chest();
                    } else {
                        return null;
                    }
                case 6:
                    if(Objects.equals(features.get(6), "0")){
                        return new frag_head();
                    } else if (Objects.equals(features.get(6), "1")) {
                        return new frag_abdomen();
                    } else if (Objects.equals(features.get(6), "2")) {
                        return new fag_throat();
                    } else if (Objects.equals(features.get(6), "3")) {
                        return new frag_lb();
                    } else if (Objects.equals(features.get(6), "4")) {
                        return new frag_ear();
                    } else if (Objects.equals(features.get(6), "5")) {
                        return new frag_eyes();
                    } else if (Objects.equals(features.get(6), "6")) {
                        return new frag_mouth();
                    }else if (Objects.equals(features.get(6), "7")){
                        return new frag_nose();
                    } else if (Objects.equals(features.get(6), "8")) {
                        return new frag_heart();
                    } else if (Objects.equals(features.get(6), "9")) {
                        return new frag_joint("jbjb");
                    } else if (Objects.equals(features.get(6), "10")) {
                        return new frag_chest();
                    } else {
                        return null;
                    }
                case 7:
                    if(Objects.equals(features.get(7), "0")){
                        return new frag_head();
                    } else if (Objects.equals(features.get(7), "1")) {
                        return new frag_abdomen();
                    } else if (Objects.equals(features.get(7), "2")) {
                        return new fag_throat();
                    } else if (Objects.equals(features.get(7), "3")) {
                        return new frag_lb();
                    } else if (Objects.equals(features.get(7), "4")) {
                        return new frag_ear();
                    } else if (Objects.equals(features.get(7), "5")) {
                        return new frag_eyes();
                    } else if (Objects.equals(features.get(7), "6")) {
                        return new frag_mouth();
                    }else if (Objects.equals(features.get(7), "7")){
                        return new frag_nose();
                    } else if (Objects.equals(features.get(7), "8")) {
                        return new frag_heart();
                    } else if (Objects.equals(features.get(7), "9")) {
                        return new frag_joint(" jnj");
                    } else if (Objects.equals(features.get(7), "10")) {
                        return new frag_chest();
                    } else {
                        return null;
                    }
                case 8:
                    if(Objects.equals(features.get(8), "0")){
                        return new frag_head();
                    } else if (Objects.equals(features.get(8), "1")) {
                        return new frag_abdomen();
                    } else if (Objects.equals(features.get(8), "2")) {
                        return new fag_throat();
                    } else if (Objects.equals(features.get(8), "3")) {
                        return new frag_lb();
                    } else if (Objects.equals(features.get(8), "4")) {
                        return new frag_ear();
                    } else if (Objects.equals(features.get(8), "5")) {
                        return new frag_eyes();
                    } else if (Objects.equals(features.get(8), "6")) {
                        return new frag_mouth();
                    }else if (Objects.equals(features.get(8), "7")){
                        return new frag_nose();
                    } else if (Objects.equals(features.get(8), "8")) {
                        return new frag_heart();
                    } else if (Objects.equals(features.get(8), "9")) {
                        return new frag_joint("jnjbj");
                    } else if (Objects.equals(features.get(8), "10")) {
                        return new frag_chest();
                    } else {
                        return null;
                    }
                case 9:
                    if(Objects.equals(features.get(9), "0")){
                        return new frag_head();
                    } else if (Objects.equals(features.get(9), "1")) {
                        return new frag_abdomen();
                    } else if (Objects.equals(features.get(9), "2")) {
                        return new fag_throat();
                    } else if (Objects.equals(features.get(9), "3")) {
                        return new frag_lb();
                    } else if (Objects.equals(features.get(9), "4")) {
                        return new frag_ear();
                    } else if (Objects.equals(features.get(9), "5")) {
                        return new frag_eyes();
                    } else if (Objects.equals(features.get(9), "6")) {
                        return new frag_mouth();
                    }else if (Objects.equals(features.get(9), "7")){
                        return new frag_nose();
                    } else if (Objects.equals(features.get(9), "8")) {
                        return new frag_heart();
                    } else if (Objects.equals(features.get(9), "9")) {
                        return new frag_joint("knk");
                    } else if (Objects.equals(features.get(9), "10")) {
                        return new frag_chest();
                    } else {
                        return null;
                    }
                case 10:
                    if(Objects.equals(features.get(10), "0")){
                        return new frag_head();
                    } else if (Objects.equals(features.get(10), "1")) {
                        return new frag_abdomen();
                    } else if (Objects.equals(features.get(10), "2")) {
                        return new fag_throat();
                    } else if (Objects.equals(features.get(10), "3")) {
                        return new frag_lb();
                    } else if (Objects.equals(features.get(10), "4")) {
                        return new frag_ear();
                    } else if (Objects.equals(features.get(10), "5")) {
                        return new frag_eyes();
                    } else if (Objects.equals(features.get(10), "6")) {
                        return new frag_mouth();
                    }else if (Objects.equals(features.get(10), "7")){
                        return new frag_nose();
                    } else if (Objects.equals(features.get(10), "8")) {
                        return new frag_heart();
                    } else if (Objects.equals(features.get(10), "9")) {
                        return new frag_joint("jnj");
                    } else if (Objects.equals(features.get(10), "10")) {
                        return new frag_chest();

                    } else {
                        return null;
                    }
                default:
                    return null;

            }

        }

        @Override
        public int getCount() {
            return temp; // Number of tabs

        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {

                case 0:
//                    if(Objects.equals(features.get(0), "0")){
//                        return "HEAD";
//                    } else if (Objects.equals(features.get(0), "1")) {
//                        return "ABDOMEN";
//                    } else if (Objects.equals(features.get(0), "2")) {
//                        return "THROAT";
//                    } else if (Objects.equals(features.get(0), "3")) {
//                        return "LOWER BACK";
//                    } else if (Objects.equals(features.get(0), "4")) {
//                        return "EAR";
//                    } else if (Objects.equals(features.get(0), "5")) {
//                        return "EYES";
//                    } else if (Objects.equals(features.get(0), "6")) {
//                        return "MOUTH";
//                    }else if (Objects.equals(features.get(0), "7")){
//                        return "NOSE";
//                    } else if (Objects.equals(features.get(0), "8")) {
//                        return "HEART";
//                    } else if (Objects.equals(features.get(0), "9")) {
//                        return "JOINTS";
//                    } else if (Objects.equals(features.get(0), "10")) {
//                        return "CHEST";
//                    }
                    return "Head";
                    case 1:
//                        if(Objects.equals(features.get(1), "0")){
//                            return "HEAD";
//                        } else if (Objects.equals(features.get(1), "1")) {
//                            return "ABDOMEN";
//                        } else if (Objects.equals(features.get(1), "2")) {
//                            return "THROAT";
//                        } else if (Objects.equals(features.get(1), "3")) {
//                            return "LOWER BACK";
//                        } else if (Objects.equals(features.get(1), "4")) {
//                            return "EAR";
//                        } else if (Objects.equals(features.get(1), "5")) {
//                            return "EYES";
//                        } else if (Objects.equals(features.get(1), "6")) {
//                            return "MOUTH";
//                        }else if (Objects.equals(features.get(1), "7")){
//                            return "NOSE";
//                        } else if (Objects.equals(features.get(1), "8")) {
//                            return "HEART";
//                        } else if (Objects.equals(features.get(1), "9")) {
//                            return "JOINTS";
//                        } else if (Objects.equals(features.get(1), "10")) {
                            return "CHEST";
//                        }
                        case 2:
//                            if(Objects.equals(features.get(2), "0")){
//                                return "HEAD";
//                            } else if (Objects.equals(features.get(2), "1")) {
//                                return "ABDOMEN";
//                            } else if (Objects.equals(features.get(2), "2")) {
//                                return "THROAT";
//                            } else if (Objects.equals(features.get(2), "3")) {
//                                return "LOWER BACK";
//                            } else if (Objects.equals(features.get(2), "4")) {
//                                return "EAR";
//                            } else if (Objects.equals(features.get(2), "5")) {
//                                return "EYES";
//                            } else if (Objects.equals(features.get(2), "6")) {
//                                return "MOUTH";
//                            }else if (Objects.equals(features.get(2), "7")){
                                return "NOSE";
//                            } else if (Objects.equals(features.get(2), "8")) {
//                                return "HEART";
//                            } else if (Objects.equals(features.get(2), "9")) {
//                                return "JOINTS";
//                            } else if (Objects.equals(features.get(2), "10")) {
//                                return "CHEST";
//                            }
                case 3:
//                    if(Objects.equals(features.get(3), "0")){
//                        return "HEAD";
//                    } else if (Objects.equals(features.get(3), "1")) {
//                        return "ABDOMEN";
//                    } else if (Objects.equals(features.get(3), "2")) {
//                        return "THROAT";
//                    } else if (Objects.equals(features.get(3), "3")) {
//                        return "LOWER BACK";
//                    } else if (Objects.equals(features.get(3), "4")) {
//                        return "EAR";
//                    } else if (Objects.equals(features.get(3), "5")) {
//                        return "EYES";
//                    } else if (Objects.equals(features.get(3), "6")) {
                        return "MOUTH";
//                    }else if (Objects.equals(features.get(3), "7")){
//                        return "NOSE";
//                    } else if (Objects.equals(features.get(3), "8")) {
//                        return "HEART";
//                    } else if (Objects.equals(features.get(3), "9")) {
//                        return "JOINTS";
//                    } else if (Objects.equals(features.get(3), "10")) {
//                        return "CHEST";
//                    }
                    case 4:
//                        if(Objects.equals(features.get(4), "0")){
//                            return "HEAD";
//                        } else if (Objects.equals(features.get(4), "1")) {
//                            return "ABDOMEN";
//                        } else if (Objects.equals(features.get(4), "2")) {
//                            return "THROAT";
//                        } else if (Objects.equals(features.get(4), "3")) {
//                            return "LOWER BACK";
//                        } else if (Objects.equals(features.get(4), "4")) {
//                            return "EAR";
//                        } else if (Objects.equals(features.get(4), "5")) {
//                            return "EYES";
//                        } else if (Objects.equals(features.get(4), "6")) {
//                            return "MOUTH";
//                        }else if (Objects.equals(features.get(4), "7")){
//                            return "NOSE";
//                        } else if (Objects.equals(features.get(4), "8")) {
                            return "HEART";
//                        } else if (Objects.equals(features.get(4), "9")) {
//                            return "JOINTS";
//                        } else if (Objects.equals(features.get(4), "10")) {
//                            return "CHEST";
//                        }
                        case 5:
//                            if(Objects.equals(features.get(5), "0")){
//                                return "HEAD";
//                            } else if (Objects.equals(features.get(5), "1")) {
//                                return "ABDOMEN";
//                            } else if (Objects.equals(features.get(5), "2")) {
//                                return "THROAT";
//                            } else if (Objects.equals(features.get(5), "3")) {
                                return "LOWER BACK";
//                            } else if (Objects.equals(features.get(5), "4")) {
//                                return "EAR";
//                            } else if (Objects.equals(features.get(5), "5")) {
//                                return "EYES";
//                            } else if (Objects.equals(features.get(5), "6")) {
//                                return "MOUTH";
//                            }else if (Objects.equals(features.get(5), "7")){
//                                return "NOSE";
//                            } else if (Objects.equals(features.get(5), "8")) {
//                                return "HEART";
//                            } else if (Objects.equals(features.get(5), "9")) {
//                                return "JOINTS";
//                            } else if (Objects.equals(features.get(5), "10")) {
//                                return "CHEST";
//                            }
                            case 6:
//                                if(Objects.equals(features.get(6), "0")){
//                                    return "HEAD";
//                                } else if (Objects.equals(features.get(6), "1")) {
//                                    return "ABDOMEN";
//                                } else if (Objects.equals(features.get(6), "2")) {
                                    return "THROAT";
//                                } else if (Objects.equals(features.get(6), "3")) {
//                                    return "LOWER BACK";
//                                } else if (Objects.equals(features.get(6), "4")) {
//                                    return "EAR";
//                                } else if (Objects.equals(features.get(6), "5")) {
//                                    return "EYES";
//                                } else if (Objects.equals(features.get(6), "6")) {
//                                    return "MOUTH";
//                                }else if (Objects.equals(features.get(6), "7")){
//                                    return "NOSE";
//                                } else if (Objects.equals(features.get(6), "8")) {
//                                    return "HEART";
//                                } else if (Objects.equals(features.get(6), "9")) {
//                                    return "JOINTS";
//                                } else if (Objects.equals(features.get(6), "10")) {
//                                    return "CHEST";
//                                }
                case 7:
//                    if(Objects.equals(features.get(7), "0")){
//                        return "HEAD";
//                    } else if (Objects.equals(features.get(7), "1")) {
                        return "ABDOMEN";
//                    } else if (Objects.equals(features.get(7), "2")) {
//                        return "THROAT";
//                    } else if (Objects.equals(features.get(7), "3")) {
//                        return "LOWER BACK";
//                    } else if (Objects.equals(features.get(7), "4")) {
//                        return "EAR";
//                    } else if (Objects.equals(features.get(7), "5")) {
//                        return "EYES";
//                    } else if (Objects.equals(features.get(7), "6")) {
//                        return "MOUTH";
//                    }else if (Objects.equals(features.get(7), "7")){
//                        return "NOSE";
//                    } else if (Objects.equals(features.get(7), "8")) {
//                        return "HEART";
//                    } else if (Objects.equals(features.get(7), "9")) {
//                        return "JOINTS";
//                    } else if (Objects.equals(features.get(7), "10")) {
//                        return "CHEST";
//                    }
                case 8:
//                    if(Objects.equals(features.get(8), "0")){
                        return "HEAD";
//                    } else if (Objects.equals(features.get(8), "1")) {
//                        return "ABDOMEN";
//                    } else if (Objects.equals(features.get(8), "2")) {
//                        return "THROAT";
//                    } else if (Objects.equals(features.get(8), "3")) {
//                        return "LOWER BACK";
//                    } else if (Objects.equals(features.get(8), "4")) {
//                        return "EAR";
//                    } else if (Objects.equals(features.get(8), "5")) {
//                        return "EYES";
//                    } else if (Objects.equals(features.get(8), "6")) {
//                        return "MOUTH";
//                    }else if (Objects.equals(features.get(8), "7")){
//                        return "NOSE";
//                    } else if (Objects.equals(features.get(8), "8")) {
//                        return "HEART";
//                    } else if (Objects.equals(features.get(8), "9")) {
//                        return "JOINTS";
//                    } else if (Objects.equals(features.get(8), "10")) {
//                        return "CHEST";
//                    }
                case 9:
//                    if(Objects.equals(features.get(9), "0")){
//                        return "HEAD";
//                    } else if (Objects.equals(features.get(9), "1")) {
//                        return "ABDOMEN";
//                    } else if (Objects.equals(features.get(9), "2")) {
//                        return "THROAT";
//                    } else if (Objects.equals(features.get(9), "3")) {
//                        return "LOWER BACK";
//                    } else if (Objects.equals(features.get(9), "4")) {
//                        return "EAR";
//                    } else if (Objects.equals(features.get(9), "5")) {
                        return "EYES";
//                    } else if (Objects.equals(features.get(9), "6")) {
//                        return "MOUTH";
//                    }else if (Objects.equals(features.get(9), "7")){
//                        return "NOSE";
//                    } else if (Objects.equals(features.get(9), "8")) {
//                        return "HEART";
//                    } else if (Objects.equals(features.get(9), "9")) {
//                        return "JOINTS";
//                    } else if (Objects.equals(features.get(9), "10")) {
//                        return "CHEST";
//                    }
                case 10:
//                    if(Objects.equals(features.get(10), "0")){
//                        return "HEAD";
//                    } else if (Objects.equals(features.get(10), "1")) {
//                        return "ABDOMEN";
//                    } else if (Objects.equals(features.get(10), "2")) {
//                        return "THROAT";
//                    } else if (Objects.equals(features.get(10), "3")) {
//                        return "LOWER BACK";
//                    } else if (Objects.equals(features.get(10), "4")) {
                        return "EAR";
//                    } else if (Objects.equals(features.get(10), "5")) {
//                        return "EYES";
//                    } else if (Objects.equals(features.get(10), "6")) {
//                        return "MOUTH";
//                    }else if (Objects.equals(features.get(10), "7")){
//                        return "NOSE";
//                    } else if (Objects.equals(features.get(10), "8")) {
//                        return "HEART";
//                    } else if (Objects.equals(features.get(10), "9")) {
//                        return "JOINTS";
//                    } else if (Objects.equals(features.get(10), "10")) {
//                        return "CHEST";
//                    }
                default:
                    return null;
                }
            }
    }



}
