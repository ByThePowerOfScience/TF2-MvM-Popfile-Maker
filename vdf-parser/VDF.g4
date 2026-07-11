
grammar VDF;

base : firstLine=line_no_newline rest+=line*;
line_no_newline : (keyvalue? comment?);

keyvalue : keyvalue_strings
   | keyvalue_table
   ;

keyable : LITERAL | STRING | NUMBER;
keyvalue_strings : key=keyable value=keyable;
keyvalue_table :
                key=keyable (keyEOLComment=comment)?
                NL value=table
                ;






table : OPENBRACE tableLBracketComment=comment?
        lines+=line+
        CLOSEBRACE;

line : NL line_no_newline
    ;

comment : COMMENT_START value=comment_end ;
comment_end : ~NL*;


WS: [\t ]+ -> skip;

STRING: '"' STRING_ELEMENT* '"' ;
LITERAL: WORDCHAR+ ;
NUMBER: '-'? [0-9]+ ('.' [0-9]+) ;

COMMENT_START : '//';


fragment STRING_ELEMENT : ~'"';

NL: '\r'? '\n';

fragment WORDCHAR: [\p{L}\p{N}\-_];

OPENBRACE : '{' ;
CLOSEBRACE : '}' ;