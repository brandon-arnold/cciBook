package io.bna.ccibook.firstancestor

import io.bna.ccibook.common.TreeNode

/**
 * Created by brand on 11/25/2016.
 */
class ReverseListAncestorFinderTest extends GroovyTestCase {
    void testAll() {
        ReverseListAncestorFinder<Integer> strat = new ReverseListAncestorFinder<>();
        TreeNode<Integer> root = new TreeNode(1);
        TreeNode<Integer> common = new TreeNode(2);
        TreeNode<Integer> node1 = new TreeNode(3);
        TreeNode<Integer> node2 = new TreeNode(4);
        for(int i = 5; i < 10; i++) {
            root.addChild(new TreeNode(i));
        }
        for(int i = 11; i < 15; i++) {
            root.children[2].addChild(new TreeNode(i));
        }
        for(int i = 16; i < 20; i++) {
            root.children[2].children[2].addChild(new TreeNode(i));
        }
        root.children[2].children[2].addChild(common);
        for(int i = 21; i < 25; i++) {
            common.addChild(new TreeNode(i));
        }
        for(int i = 26; i < 30; i++) {
            common.children[2].addChild(new TreeNode(i));
        }
        common.children[2].children[2].addChild(node1);
        for(int i = 31; i < 35; i++) {
            common.children[3].addChild(new TreeNode(i));
        }
        common.children[2].children[3].addChild(node2);
        assertEquals(common, strat.find(node1, node2));
    }
}
