package Interpreter;

/**
 * @author zhp
 * @date 2022-08-22 21:51
 */

/** 解释器模式
 *
 * 基本介绍
 * 1) 在编译原理中，一个算术表达式通过词法分析器形成词法单元，而后这些词法单元再通过语法分析器构建语法
 * 分析树，最终形成一颗抽象的语法分析树。这里的词法分析器和语法分析器都可以看做是解释器
 * 2) 解释器模式（Interpreter Pattern）：是指给定一个语言(表达式)，定义它的文法的一种表示，并定义一个解释器，
 * 使用该解释器来解释语言中的句子(表达式)
 * 3) 应用场景
 * -应用可以将一个需要解释执行的语言中的句子表示为一个抽象语法树
 * -一些重复出现的问题可以用一种简单的语言来表达-一个简单语法需要解释的场景
 * 4) 这样的例子还有，比如编译器、运算表达式计算、正则表达式、机器人等，具体例子可见《图解设计模式》解释器模式一章。
 *
 * 解释器模式的注意事项和细节
 * 1) 当有一个语言需要解释执行，可将该语言中的句子表示为一个抽象语法树，就可以考虑使用解释器模式，让程
 * 序具有良好的扩展性
 * 2) 应用场景：编译器、运算表达式计算、正则表达式、机器人等
 * 3) 使用解释器可能带来的问题：解释器模式会引起类膨胀、解释器模式采用递归调用方法，将会导致调试非常复
 * 杂、效率可能降低
 */
public class Interpreter {
}
