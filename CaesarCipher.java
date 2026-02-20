/**
 * @(#)CaesarCipher.java
 *
 *
 * @author
 * @version 1.00 2025/2/20
 */


public class CaesarCipher {

	private char[] alphabet;
	private char[] shifted;
	private int shift;

    public CaesarCipher() 
    {
        alphabet = new char[26];
        String alp = "abcdefghijklmnopqrstuvwxyz";

        for(int i = 0;i<alphabet.length;i++)
        {
            alphabet[i] = alp.charAt(i);
        }

    }

    public CaesarCipher(int num)
    {
        alphabet = new char[26];
        String alp = "abcdefghijklmnopqrstuvwxyz";
        for(int i = 0; i<alphabet.length;i++)
        {
            alphabet[i] = alp.charAt(i);
        }
        shift = num;
        shifter(num);

    }

    public String encrypt(String message)
    {
        String encry = "";
        for(int i = 0;i<message.length(); i++)
        {
            int count = -1;

            for(int x = 0; x<26;x++)
            {
                if(message.charAt(i) == alphabet[x])
                {
                    count = x;
                }
            }
            if (count == -1) 
            {
                encry += message.charAt(i);
            }
            else
            {
                encry += shifted[count];
            }
        }
        return encry;
    }

    public String decrypt(String message)
    {
        String decrypt = "";

        for(int i = 0; i < message.length();i++)
        {
            int count = -1;
            for(int x = 0; x < 26; x++)
            {
                if(message.charAt(i) == shifted[x])
                {
                    count = x;
                }
            }
            if(count == -1)
            {
                decrypt += message.charAt(i);
            }
            else
            {
                decrypt += alphabet[count];
            }
        }
        return decrypt;
    }

    public void shifter(int num)
    {
        shifted = new char[26];
        for(int i = 0; i < 26; i++)
        {
            shifted[i] = alphabet[(i+num) % 26];
        }
            
    }


}