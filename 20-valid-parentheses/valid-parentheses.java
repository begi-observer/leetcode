class Solution {
    public boolean isValid(String s) {
        String str =""; 
        char ch;
        for(int i = 0;i< s.length();i++)
        {
            ch = s.charAt(i);
            if(str.length()==0 & (ch == ')'||ch=='}'||ch==']'))
            {
                return false;
            }
            if(ch==')')
            {
                if(str.charAt(str.length()-1)=='(')
                {
                    if(str.length()==1)
                    {
                        str="";
                    }
                    else
                    {
                        str = str.substring(0,str.length()-1);
                    }    
                    
                }
                else
                {
                    return false;
                }
            }
            else if(ch=='}')
            {
                if(str.charAt(str.length()-1)=='{')
                {
                    if(str.length()==1)
                    {
                        str="";
                    }
                    else
                    {
                        str = str.substring(0,str.length()-1);
                    }          
                }
                else
                {
                    return false;
                }
            }
            else if(ch==']')
            {
                if(str.charAt(str.length()-1)=='[')
                {
                    if(str.length()==1)
                    {
                        str="";
                    }
                    else
                    {
                        str= str.substring(0,str.length()-1);
                    }
                }
                else
                {
                    return false;
                }
            }
            else 
            {
                str += "" + ch;
            }
        }
        if(str =="")
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}