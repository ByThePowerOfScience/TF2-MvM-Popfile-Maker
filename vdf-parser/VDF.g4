
grammar VDF;

root : lines+=line*;

line : keyvalue | COMMENT | keyvalue COMMENT;

keyvalue : keyvalue_strings
   | keyvalue_table
   ;

keyable : LITERAL | STRING;
keyvalue_strings : (key=keyable CONDITIONAL value=keyable) | (key=keyable value=keyable CONDITIONAL?);
keyvalue_table :
                key=keyable CONDITIONAL? keyEOLComment+=COMMENT*
                 value=table
                ;

table : OPENBRACE tableLBracketComment=COMMENT?
        lines+=line*
        CLOSEBRACE;



COMMENT : COMMENT_START .*? NL ;

WS: [\p{Zs}\t]+ -> skip;

STRING: QUOTE (STRING_ELEMENT)* QUOTE ;
LITERAL: ~('[' | ["{}\p{Zs}\t\n\r]) ~["{}\p{Zs}\t\n\r]* ;

fragment NON_LITERAL_ELEMENT : ["{}\p{Zs}\t\n\r] ;

CONDITIONAL : '[' .+? ']';

QUOTE : '"';

COMMENT_START : '//';

fragment STRING_ELEMENT : '\\"' | ~'"';

NL: '\r'? '\n' -> skip;

//fragment WORDCHAR: [\p{L}\p{N}\-_.#];

OPENBRACE : '{' ;
CLOSEBRACE : '}' ;

//PRAGMA : '#' WORDCHAR+ (WS | WORDCHAR | '.')+;
