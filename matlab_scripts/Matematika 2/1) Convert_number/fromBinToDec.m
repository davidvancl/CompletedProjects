function out = fromBinToDec(bin)
    out = 0;
    outBefore = 0;
    outBehind = 0;
    
    tmp = split(bin,".");
    before = convertStringsToChars(tmp(1) + "");
    behind = convertStringsToChars(tmp(2) + "");
    
    for i = 1: length(before)
        outBefore = outBefore + (str2double(before(i)) * 2^(length(before) - i));
    end
    
    for i = 1: length(behind)
        outBehind = outBehind + (str2double(behind(i)) * (1 / 2^(i)));
    end
    
    out = outBefore + outBehind;
end