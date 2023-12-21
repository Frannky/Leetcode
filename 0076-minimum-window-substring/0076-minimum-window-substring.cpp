class Solution {
public:
    int countS[60];
    int countT[60];
    string minWindow(string s, string t) {
        for(auto& c : t)
        {
            countT[c - 'A']++;
        }
        
        int i = 0, j = 0, N = s.length();
        int ans = INT_MAX, start = 0, end = 0;
        
        while(i < N)
        {
            while(j < N && !valid())
            {
                countS[s[j] - 'A']++;
                j++;
            }
            
            if(j - i + 1 < ans && valid())
            {
                ans = j - i + 1;
                start = i;
                end = j;
            }
            
            countS[s[i] - 'A']--;
            i++;
        }
        
        return s.substr(start, end - start);
    }
    
    bool valid()
    {
        for(int i = 0; i < 60; i++)
        {
            if(countS[i] < countT[i]) return false;
        }
        
        return true;
    }
};