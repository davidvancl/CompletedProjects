function out = fromDecToBin(dec)

    decRound = floor(dec);
    decPoint = dec - decRound;
    
    out = '';
    while(decRound ~= 0)
        zb = mod(decRound,2);
        out = append(num2str(out),num2str(zb));
        decRound = floor(decRound / 2);
    end
    
    outPoint = '';
    for i = 1:10
        delim = (1/2)^i;
        if(delim < decPoint)
            outPoint = append(outPoint,'1');
            decPoint = decPoint - delim;
        else
            outPoint = append(outPoint,'0');
        end
    end
    
    tmp = '';
    for i = length(out):-1:1
        tmp = append(tmp,out(i));
    end
    out = tmp;
    out = append(out,'.');
    out = append(out,outPoint);
end